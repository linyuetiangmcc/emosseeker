package com.gmcc.emosseeker.dbentity;

import lombok.Data;

import java.util.Date;

@Data
public class OperationRecord {
    private Integer userId;
    private Date createTime;
    private Date updateTime;
    private String wsid;
    private String taskId;
    private String auditAdvice;
    private Integer auditResult;
    private String wsHintInfo;
}
