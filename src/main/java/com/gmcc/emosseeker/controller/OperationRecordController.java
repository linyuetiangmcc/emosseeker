package com.gmcc.emosseeker.controller;

import com.gmcc.emosseeker.constant.CookieConstant;
import com.gmcc.emosseeker.constant.RedisConstant;
import com.gmcc.emosseeker.dbentity.OperationRecord;
import com.gmcc.emosseeker.dbentity.UserInfo;
import com.gmcc.emosseeker.service.OperationRecordService;
import com.gmcc.emosseeker.service.UserInfoService;
import com.gmcc.emosseeker.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oplog")
public class OperationRecordController {
    @Autowired
    private OperationRecordService operationRecordService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String, Object> list(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Cookie cookie = getCookie();
        if(cookie == null){
            System.out.println("查询日志因用户没有cookie失败");
            modelMap.put("success",false);
            return modelMap;
        }
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        UserInfo userInfo = userInfoService.getUserInfoByOpenId(openid);
        List<OperationRecord> operationRecordList = operationRecordService.queryOperationRecordByUserId(userInfo.getUserId());
        modelMap.put("operationRecordList",operationRecordList);
        modelMap.put("success",true);
        return modelMap;
    }

    private Cookie getCookie(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return  CookieUtil.get(request, CookieConstant.TOKEN);
    }
}
