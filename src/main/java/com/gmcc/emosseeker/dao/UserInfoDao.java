package com.gmcc.emosseeker.dao;

import com.gmcc.emosseeker.dbentity.UserInfo;
import java.util.List;

public interface UserInfoDao {
    List<UserInfo> queryUserInfoList();
    UserInfo queryUserInfoByUserId(String userId);
    UserInfo queryUserInfoByOpenId(String openId);
    int insertUserInfo(UserInfo userInfo);
    int updateUserInfo(UserInfo userInfo);
    int deleteUserInfoByUserId(String userId);
    int deleteUserInfoByOpenId(String openId);
}
