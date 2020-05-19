package com.gmcc.emosseeker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListRaw {
    @JsonProperty("createGroupCode")
    private String creategroupcode;
    @JsonProperty("createGroupId")
    private String creategroupid;
    @JsonProperty("createGroupName")
    private String creategroupname;
    @JsonProperty("createNetuserid")
    private String createnetuserid;
    @JsonProperty("createUsername")
    private String createusername;
    @JsonProperty("dictValue")
    private String dictvalue;
    private boolean expand;
    @JsonProperty("factoryAcceptLimit")
    private String factoryacceptlimit;
    @JsonProperty("factoryAcceptLimitTime")
    private String factoryacceptlimittime;
    @JsonProperty("factoryHandleLimit")
    private String factoryhandlelimit;
    @JsonProperty("factoryHandleLimitTime")
    private String factoryhandlelimittime;
    @JsonProperty("hasChild")
    private int haschild;
    @JsonProperty("isCopy")
    private String iscopy;
    @JsonProperty("prvId")
    private String prvid;
    @JsonProperty("prvName")
    private String prvname;
    @JsonProperty("regionFullName")
    private String regionfullname;
    @JsonProperty("regionName")
    private String regionname;
    @JsonProperty("taskId")
    private String taskid;
    @JsonProperty("wsBegintime")
    private String wsbegintime;
    @JsonProperty("wsHintInfo")
    private String wshintinfo;
    @JsonProperty("wsStatusCode")
    private String wsstatuscode;
    @JsonProperty("wsStatusName")
    private String wsstatusname;
    @JsonProperty("wsStatusSn")
    private String wsstatussn;
    @JsonProperty("wsTimeoutStatus")
    private String wstimeoutstatus;
    @JsonProperty("wsTypeCode")
    private String wstypecode;
    @JsonProperty("wsTypeName")
    private String wstypename;
    private String wsid;
}
