package com.gmcc.emosseeker.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmcc.emosseeker.common.HttpClientUtil;
import com.gmcc.emosseeker.common.JsonUtils;
import com.gmcc.emosseeker.entity.*;
import com.gmcc.emosseeker.entity.hardwaredetail.DataDetailHardWare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value = "/worksheet")
public class WorkSheetController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String, Object>  list(@RequestParam(defaultValue = "0") Integer type){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ListRaw> result = new ArrayList<>();
        List<ListRaw> result_post = new ArrayList<>();
        boolean lastPageFlag = false;
        int paageNum = 1;
        String zy_token = redisTemplate.opsForValue().get("jtemos_zy_token");
        while (!lastPageFlag && paageNum<=20){
            String url = "https://fee.net.chinamobile.com/api/eoms/workflow/app/query/customRouterKey/queryTodoWorksheetList";
            String postJson = "{\"pageNum\":\"" + paageNum + "\",\"pageSize\":\"100\",\"userType\":\"inner\"}";
            Map<String,String> header = new HashMap<>();
            header.put("zy_token",zy_token);
            //header.put("zy_token","web_2846beb8-a59c-45f6-a8ae-acf1c18e1fb5");
            String resultstr = HttpClientUtil.doPostJson(url,postJson,header);
            if(!resultstr.contains("\"code\":\"0000\"")){
                modelMap.put("success",false);
                return modelMap;
            }
            PostResult postResult = JsonUtils.jsonToPojo(resultstr,PostResult.class);
            String jsonstr = JsonUtils.objectToJson(postResult.getData());
            try{
                DataRaw dataRaw = new ObjectMapper().readValue(jsonstr, DataRaw.class);
                List<ListRaw> post_row = dataRaw.getList();
                for (ListRaw listRaw:post_row
                     ) {
                    result_post.add(listRaw);
                }
                if(dataRaw.isIslastpage())
                {
                    lastPageFlag = true;
                    break;
                }
                System.out.println(dataRaw);
            }catch (Exception ex){
                ex.printStackTrace();
                modelMap.put("success",false);
                return modelMap;
            }
            paageNum ++;
        }
        /*
        0:all
        1:现场服务
        2:硬件返修
        3:故障处理
        4:技术咨询
        */
        Map<Integer,String> keyValues = new HashMap();
        keyValues.put(1,"fieldService");
        keyValues.put(2,"hardwareRepair");
        keyValues.put(3,"faultHandling");
        keyValues.put(4,"technologyConsult");

        //System.out.println(type);

        if(type == 0) {
            modelMap.put("success",true);
            modelMap.put("workSheetList",result_post);
            return modelMap;
        }
        else{
            for (ListRaw listRaw:result_post
            ) {
                if(listRaw.getWstypecode().equals(keyValues.get(type)) && listRaw.getWsstatuscode().equals("workflow_audit")){
                    result.add(listRaw);
                }
            }
            modelMap.put("success",true);
            modelMap.put("workSheetList",result);
            return modelMap;
        }
    }

    @RequestMapping(value = "/sceneService/detail",method = RequestMethod.GET)
    public Map<String, Object>  detail(@RequestParam(required = true) String wsid) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //wsid = "XCFW-GD-20200515-000002";
        String url = "https://fee.net.chinamobile.com/api/eoms/workflow/app/sceneService/detailInfo?wsid=" + wsid;
        Map<String,String> header = new HashMap<>();
        String zy_token = redisTemplate.opsForValue().get("jtemos_zy_token");
        header.put("zy_token",zy_token);
        //header.put("zy_token","web_2846beb8-a59c-45f6-a8ae-acf1c18e1fb5");
        //header.put("Cookie","zy_token=web_6609e53a-35d5-4497-8565-a1f32ca87195;");
        String resultstr = HttpClientUtil.doGet(url,null,header);
        //System.out.println(resultstr);
        if(!resultstr.contains("\"code\":\"0000\"")){
            modelMap.put("success",false);
            return modelMap;
        }
        PostResult postResult = JsonUtils.jsonToPojo(resultstr,PostResult.class);
        String jsonstr = JsonUtils.objectToJson(postResult.getData());
        try {
            DataDetail dataDetail = new ObjectMapper().readValue(jsonstr, DataDetail.class);
            modelMap.put("workSheetDetail",dataDetail);
            modelMap.put("success",true);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return modelMap;
    }

    @RequestMapping(value = "/hardwareRepair/detail",method = RequestMethod.GET)
    public Map<String, Object>  hwdetail(@RequestParam(required = true) String wsid) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //wsid = "XCFW-GD-20200515-000002";
        String url = "https://fee.net.chinamobile.com/api/eoms/workflow/app/hardwareRepair/detailInfo?wsid=" + wsid;
        Map<String,String> header = new HashMap<>();
        String zy_token = redisTemplate.opsForValue().get("jtemos_zy_token");
        header.put("zy_token",zy_token);
        String resultstr = HttpClientUtil.doGet(url,null,header);
        if(!resultstr.contains("\"code\":\"0000\"")){
            modelMap.put("success",false);
            return modelMap;
        }
        PostResult postResult = JsonUtils.jsonToPojo(resultstr,PostResult.class);
        String jsonstr = JsonUtils.objectToJson(postResult.getData());
        try {
            DataDetailHardWare dataDetailHardWare = new ObjectMapper().readValue(jsonstr, DataDetailHardWare.class);
            modelMap.put("workSheetDetail",dataDetailHardWare);
            modelMap.put("success",true);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return modelMap;
    }


    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    public Map<String, Object> audit(@Valid @RequestBody PostAuditForm postAuditForm, BindingResult bindingResult){
        Map<String, Object> modelMap = new HashMap<String, Object>();

        if(bindingResult.hasErrors()){
            //System.out.println(bindingResult.getFieldError().getDefaultMessage());
            modelMap.put("success", false);
            modelMap.put("message",bindingResult.getFieldError().getDefaultMessage());
            return modelMap;
        }


        PostAudit postAudit = new PostAudit();
        postAudit.setTaskId(postAuditForm.getTaskId());  //前端传参数
        postAudit.setWsid(postAuditForm.getWsid());    //前端传参数
        postAudit.setAuditAdvice(postAuditForm.getAuditAdvice());//前端传参数
        postAudit.setAuditResult(postAuditForm.getAuditResult());//前端传参数  同意为1，不同意为0。
        postAudit.setAuditNetuserid("zhoulidong@gd.cmcc");
        postAudit.setAuditUsername("周立栋");
        postAudit.setAuditEmail("zhoulidong@gd.chinamobile.com");
        postAudit.setAuditPhone("13922200557");

        //System.out.println(postAudit);

        String url = "https://fee.net.chinamobile.com/api/eoms/workflow/app/sceneService/audit";
        Map<String,String> header = new HashMap<>();
        String zy_token = redisTemplate.opsForValue().get("jtemos_zy_token");
        header.put("zy_token",zy_token);
        String jsonStr = JsonUtils.objectToJson(postAudit);
        String resultStr = HttpClientUtil.doPostJson(url,jsonStr,header);
        System.out.println(resultStr);
        PostResult postResult = JsonUtils.jsonToPojo(resultStr,PostResult.class);
        if(!resultStr.contains("\"code\":\"0000\"")){
            modelMap.put("success",false);
        }else{
            modelMap.put("success",true);
        }
        modelMap.put("result",postResult);
        return modelMap;
    }
}
