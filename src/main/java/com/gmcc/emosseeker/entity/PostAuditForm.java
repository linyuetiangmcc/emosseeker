package com.gmcc.emosseeker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class PostAuditForm {
    @JsonProperty("auditAdvice")
    @NotEmpty(message = "审批意见必填")
    private String auditAdvice;
    @JsonProperty("auditResult")
    @NotNull(message = "审批结果必填")
    private Integer auditResult;
    @JsonProperty("taskId")
    @NotEmpty(message = "工单号必填")
    private String taskId;
    @NotEmpty(message = "任务号必填")
    private String wsid;
    @NotEmpty(message = "工单主题必填")
    private String wsHintInfo;
}
