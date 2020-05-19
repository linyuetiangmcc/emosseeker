package com.gmcc.emosseeker.service.impl;

import com.gmcc.emosseeker.dao.UserInfoDao;
import com.gmcc.emosseeker.dbentity.UserInfo;
import com.gmcc.emosseeker.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private  UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> getUserInfoList() {
        return userInfoDao.queryUserInfoList();
    }

    @Override
    public UserInfo getUserInfoByUserId(String userId) {
        return userInfoDao.queryUserInfoByUserId(userId);
    }

    @Override
    public UserInfo getUserInfoByOpenId(String openId) {
        return userInfoDao.queryUserInfoByOpenId(openId);
    }

    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        int effectNumber = userInfoDao.insertUserInfo(userInfo);
        if(effectNumber == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean modifyUserInfo(UserInfo userInfo) {
        int effectNumber = userInfoDao.updateUserInfo(userInfo);
        if(effectNumber == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteUserInfoByUserId(String userId) {
        int effectNumber = userInfoDao.deleteUserInfoByUserId(userId);
        if(effectNumber == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteUserInfoByOpenId(String openId) {
        int effectNumber = userInfoDao.deleteUserInfoByOpenId(openId);
        if(effectNumber == 1)
            return true;
        else
            return false;
    }
}
