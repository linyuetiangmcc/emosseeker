package com.gmcc.emosseeker.schedule;


import com.gmcc.emosseeker.common.HttpClientUtil;
import com.gmcc.emosseeker.common.JsonUtils;
import com.gmcc.emosseeker.entity.PostResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JtEmosSchedule {

    //@Scheduled(cron="10 * * * * ?")
    /*@Scheduled(fixedDelay=10000)
    public void getdata(){
        String url = "http://10.217.240.30:8080/api/eoms/workflow/query/bySynthetical";
        String postJson = "{\"wsid\":\"\",\"wsStatusCode\":\"\",\"wsBegintimeOne\":\"\",\"wsBegintimeTwo\":\"\",\"wsEndtimeOne\":\"\",\"wsEndtimeTwo\":\"\",\"prvId\":\"\",\"regionId\":\"\",\"countyId\":\"\",\"wsTypeCode\":\"fieldService\",\"keyWord\":\"\",\"majorCode\":\"\",\"MajorCodeM\":\"\",\"wsHintInfo\":\"\",\"createUsername\":\"\",\"handleUsername\":\"\",\"createGroupId\":\"\",\"workFlowPagingReq\":{\"pageNumber\":1,\"size\":2},\"servFactoryCode\":\"\",\"acceptUsername\":\"\",\"factoryFlag\":0}";
        String cookie = "csrfToken=k0CdySowoD4Q02N8KM5a0Xzc;";
        String csrfToken= "k0CdySowoD4Q02N8KM5a0Xzc";
        String zyToken = "web_b7343adb-0a00-49d7-80bf-67e8e049339b";
        *//*if(cookie != null && csrfToken!= null && zyToken != null) {
            httpPost.addHeader("Cookie", cookie);
            httpPost.addHeader("x-csrf-token",csrfToken);
            httpPost.addHeader("zy_token",zyToken);
        }*//*
        Map<String,String> header = new HashMap<>();
        header.put("Cookie",cookie);
        header.put("x-csrf-token",csrfToken);
        header.put("zy_token",zyToken);
        String result = HttpClientUtil.doPostJson(url,postJson,header);
        PostResult postResult = JsonUtils.jsonToPojo(result,PostResult.class);
        System.out.println(postResult);

        Date now = new Date();
        System.out.println(now + " get data finished");
    }*/
}
