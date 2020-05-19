package com.gmcc.emosseeker.controller;


import com.gmcc.emosseeker.constant.CookieConstant;
import com.gmcc.emosseeker.constant.RedisConstant;
import com.gmcc.emosseeker.dbentity.UserInfo;
import com.gmcc.emosseeker.entity.UserInfoApp;
import com.gmcc.emosseeker.entity.hardwaredetail.UserInfoForm;
import com.gmcc.emosseeker.enums.ResultEnum;
import com.gmcc.emosseeker.service.UserInfoService;
import com.gmcc.emosseeker.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @GetMapping("/my")
    public Map<String, Object> my(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Cookie cookie = getCookie();
        if(cookie == null){
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.LOGIN_FAIL);
            return modelMap;
        }

        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        UserInfo userInfo = userInfoService.getUserInfoByOpenId(openid);
        if(userInfo != null){
            modelMap.put("user",userInfo);
        }
        return modelMap;
    }



    @PostMapping("/addUser")
    public  Map<String, Object> addUser(@RequestBody UserInfoApp userInfoApp) throws Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Cookie cookie = getCookie();
        if(cookie == null){
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.LOGIN_FAIL);
            return modelMap;
        }
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(openid == null){
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.LOGIN_FAIL);
            return modelMap;
        }
        if(userInfoService.getUserInfoByOpenId(openid) != null){
            modelMap.put("success", true);
            modelMap.put("message", ResultEnum.USER_EXIST);
            return modelMap;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenId(openid);
        userInfo.setAvatarUrl(userInfoApp.getAvatarUrl());
        userInfo.setCity(userInfoApp.getCity());
        userInfo.setCountry(userInfoApp.getCountry());
        userInfo.setGender(userInfoApp.getGender());
        userInfo.setLanguage(userInfoApp.getLanguage());
        userInfo.setNickName(userInfoApp.getNickName());
        userInfo.setProvince(userInfoApp.getProvince());
        userInfo.setStatus(0);
        userInfo.setUsername("");
        if(userInfoService.addUserInfo(userInfo)) {
            modelMap.put("success", true);
            modelMap.put("message", ResultEnum.USER_ADDSUCCESS);
            return modelMap;
        }
        else {
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.USER_ADDFAIL);
            return modelMap;
        }
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody UserInfoForm userInfoForm) throws Exception{
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println(userInfoForm);
        Cookie cookie = getCookie();
        if(cookie == null){
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.LOGIN_FAIL);
            return modelMap;
        }
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(openid == null){
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.LOGIN_FAIL);
            return modelMap;
        }

        UserInfo userInfo = userInfoService.getUserInfoByOpenId(openid);
        userInfo.setUsername(userInfoForm.getUsername());
        userInfo.setTelNumber(userInfoForm.getTelNumber());
        userInfo.setStatus(2);  //0 没提交  1 已审核 2 已提交审核但没通过


        if(userInfoService.modifyUserInfo(userInfo)) {
            modelMap.put("success", true);
            modelMap.put("message", ResultEnum.COMMIT_SH_SUCCESS);
            return modelMap;
        }
        else {
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.COMMIT_SH__FAIL);
            return modelMap;
        }
    }

    @PutMapping("/settel")
    public  Map<String, Object> settel(@RequestParam String telNumber) throws Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        if(!isMobile(telNumber)){
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.TEL_FORMATERROR);
            return modelMap;
        }

        Cookie cookie = getCookie();
        if(cookie == null){
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.LOGIN_FAIL);
            return modelMap;
        }
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(openid == null){
            modelMap.put("success", false);
            modelMap.put("message", ResultEnum.LOGIN_FAIL);
            return modelMap;
        }

        UserInfo userInfo = userInfoService.getUserInfoByOpenId(openid);
        userInfo.setTelNumber(telNumber);

        //System.out.println(userInfo);

        if(userInfoService.modifyUserInfo(userInfo)) {
            modelMap.put("success", true);
            modelMap.put("message", ResultEnum.SET_TEL_SUCCESS);
            return modelMap;
        }
        else {
            modelMap.put("success", true);
            modelMap.put("message", ResultEnum.SET_TEL_FAIL);
            return modelMap;
        }
    }

    private Cookie getCookie(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return  CookieUtil.get(request, CookieConstant.TOKEN);
    }

    private boolean isMobile(String mobiles) {
        Pattern p = Pattern.compile("^1(3|5|7|8|4|6|9)\\d{9}");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


}
