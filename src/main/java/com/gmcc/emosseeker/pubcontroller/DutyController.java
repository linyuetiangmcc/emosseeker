package com.gmcc.emosseeker.pubcontroller;

import com.gmcc.emosseeker.common.JsonUtils;
import com.gmcc.emosseeker.constant.RedisConstant;
import com.gmcc.emosseeker.entity.DutyInfo;
import com.gmcc.emosseeker.entity.UserInfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/duty")
public class DutyController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping(value = "/set",method = RequestMethod.POST)
    public Map<String, Object> set(@RequestBody DutyInfo dutyInfo){
        Map<String, Object> modelMap = new HashMap<String, Object>();

        String jsonStr = JsonUtils.objectToJson(dutyInfo);
        stringRedisTemplate.opsForValue().set(RedisConstant.KEY_DUTY_INFO,jsonStr);
        modelMap.put("success",true);
        return modelMap;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String, Object> list(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String jsonStr = stringRedisTemplate.opsForValue().get(RedisConstant.KEY_DUTY_INFO);
        DutyInfo dutyInfo = JsonUtils.jsonToPojo(jsonStr,DutyInfo.class);
        modelMap.put("dutyInfo",dutyInfo);
        modelMap.put("success",true);
        return modelMap;
    }


}
