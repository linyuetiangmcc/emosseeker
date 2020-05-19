package com.gmcc.emosseeker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class PostAudit {
    @JsonProperty("auditNetuserid")
    private String auditNetuserid;
    @JsonProperty("auditUsername")
    private String auditUsername;
    @JsonProperty("auditEmail")
    private String auditEmail;
    @JsonProperty("auditPhone")
    private String auditPhone;
    @JsonProperty("auditAdvice")
    private String auditAdvice;
    @JsonProperty("auditResult")
    private int auditResult;
    @JsonProperty("taskId")
    private String taskId;
    private String wsid;
}
