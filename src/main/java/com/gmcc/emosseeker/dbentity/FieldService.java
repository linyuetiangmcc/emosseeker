package com.gmcc.emosseeker.dbentity;

import lombok.Data;

import java.util.Date;
@Data
public class FieldService {
    private String createUsername;   //创建者用户名
    private Date factoryHandleLimitTime; //处理时限
    private String majorCode;
    private String majorName;   //专业
    private Date wsBegintime;  //建单时间
    private String wsFyPattern; //计价模式
    private String wsHintInfo;   //工单标题
    private String wsStatusName; //工单状态
    private String wsTypeCode; //wsTypeCode=fieldService
    private String wsTypeName; //wsTypeName=省-现场服务工单
    private String wsid;  //工单号
}
