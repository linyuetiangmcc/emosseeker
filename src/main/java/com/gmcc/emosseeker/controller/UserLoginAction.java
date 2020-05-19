package com.gmcc.emosseeker.controller;
import com.gmcc.emosseeker.common.HttpClientUtil;
import com.gmcc.emosseeker.common.JsonUtils;
import com.gmcc.emosseeker.constant.CookieConstant;
import com.gmcc.emosseeker.constant.RedisConstant;
import com.gmcc.emosseeker.entity.WXSessionModel;
import com.gmcc.emosseeker.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserLoginAction {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/wxLogin")
    public Map<String, Object> wxLogin(String code, HttpServletResponse response) throws Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wx7e0ef115f59557f2");
        param.put("secret", "a2d69f9fe2d79ec25273d9cdc2a73580");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        String wxResult = HttpClientUtil.doGet(url,param,null);
        //System.out.println(wxResult);
        WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);


        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        //带有token的cookie，更新时间。
        if(cookie != null){
            redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()),model.getOpenid(),RedisConstant.EXPIRE, TimeUnit.SECONDS);
            modelMap.put("success",true);
            return modelMap;
        }


        //没有登陆，写入cookie键为token前缘，值为openid
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),model.getOpenid(),expire, TimeUnit.SECONDS);
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        //刷新session-key 到redis
        redisTemplate.opsForValue().set("jtemos-user-redis-session:" + model.getOpenid(),model.getSession_key(),expire,TimeUnit.SECONDS);
        modelMap.put("success",true);
        return modelMap;
    }
}
