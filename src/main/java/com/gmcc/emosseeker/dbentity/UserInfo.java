package com.gmcc.emosseeker.dbentity;

import lombok.Data;
import java.util.Date;

@Data
public class UserInfo {
    private Integer userId;
    private String openId;
    private Date createTime;
    private Date updateTime;
    private String telNumber;
    private String avatarUrl;
    private String city;
    private String country;
    private Integer gender;
    private String language;
    private String nickName;
    private String province;
    private Integer status;
    private String username;
    private Integer opflag;  //0没有权限处理工单 1有onsite 2 有硬件 3 有onsite及硬件
}
