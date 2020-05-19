package com.gmcc.emosseeker.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Base {
    private String createGroupCode;
    private String createGroupId;
    private String createGroupName;
    private String createNetuserid;
    private String createUsername;   //创建者用户名
    private Date factoryAcceptLimit;
    private Date factoryAcceptLimitTime;
    private Date factoryHandleLimit;
    private Date factoryHandleLimitTime; //处理时限
    private Integer hasChild;
    private String id;
    private String majorCode;
    private String majorName;   //专业
    private Date orderTime;
    private String prvId;
    private String prvName;
    private String regionId;
    private String regionName;
    private Date wsBegintime;  //建单时间
    private Date wsEndtime;
    private String wsFyPattern; //计价模式
    private String wsHintInfo;   //工单标题
    private String wsStatusCode;
    private String wsStatusName; //工单状态
    private String wsTypeCode; //wsTypeCode=fieldService
    private String wsTypeName; //wsTypeName=省-现场服务工单
    private String wsid;  //工单号
}
