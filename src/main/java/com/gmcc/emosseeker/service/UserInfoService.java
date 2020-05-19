package com.gmcc.emosseeker.service;

import com.gmcc.emosseeker.dbentity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> getUserInfoList();
    UserInfo getUserInfoByUserId(String userId);
    UserInfo getUserInfoByOpenId(String openId);
    boolean addUserInfo(UserInfo userInfo);
    boolean modifyUserInfo(UserInfo userInfo);
    boolean deleteUserInfoByUserId(String userId);
    boolean deleteUserInfoByOpenId(String openId);
}
