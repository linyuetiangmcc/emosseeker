package com.gmcc.emosseeker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Baseworksheetresp {
    @JsonProperty("businessNumber")
    private String businessnumber;
    @JsonProperty("conCode")
    private String concode;
    @JsonProperty("conCreateDate")
    private String concreatedate;
    @JsonProperty("conEndDate")
    private String conenddate;
    @JsonProperty("conFyPatternName")
    private String confypatternname;
    @JsonProperty("conName")
    private String conname;
    @JsonProperty("conStartDate")
    private String constartdate;
    @JsonProperty("conStatus")
    private String constatus;
    @JsonProperty("createGroupCode")
    private String creategroupcode;
    @JsonProperty("createGroupId")
    private String creategroupid;
    @JsonProperty("createGroupName")
    private String creategroupname;
    @JsonProperty("createMail")
    private String createmail;
    @JsonProperty("createMobile")
    private String createmobile;
    @JsonProperty("createNetuserid")
    private String createnetuserid;
    @JsonProperty("createPhone")
    private String createphone;
    @JsonProperty("createUsername")
    private String createusername;
    @JsonProperty("factoryAcceptEndTime")
    private String factoryacceptendtime;
    @JsonProperty("factoryAcceptLimit")
    private String factoryacceptlimit;
    @JsonProperty("factoryAcceptLimitTime")
    private String factoryacceptlimittime;
    @JsonProperty("factoryAcceptResult")
    private String factoryacceptresult;
    @JsonProperty("factoryAcceptStartTime")
    private String factoryacceptstarttime;
    @JsonProperty("factoryAcceptTimeValue")
    private String factoryaccepttimevalue;
    @JsonProperty("factoryAcceptTimeoutValue")
    private int factoryaccepttimeoutvalue;
    @JsonProperty("factoryHandleEndTime")
    private String factoryhandleendtime;
    @JsonProperty("factoryHandleLimit")
    private String factoryhandlelimit;
    @JsonProperty("factoryHandleLimitTime")
    private String factoryhandlelimittime;
    @JsonProperty("factoryHandleResult")
    private String factoryhandleresult;
    @JsonProperty("factoryHandleStartTime")
    private String factoryhandlestarttime;
    @JsonProperty("factoryHandleTimeValue")
    private String factoryhandletimevalue;
    @JsonProperty("factoryHandleTimeoutValue")
    private int factoryhandletimeoutvalue;
    @JsonProperty("factoryTimeout")
    private int factorytimeout;
    @JsonProperty("factoryTimeoutValue")
    private int factorytimeoutvalue;
    @JsonProperty("hasChild")
    private int haschild;
    private String id;
    @JsonProperty("lastUpdateTime")
    private long lastupdatetime;
    @JsonProperty("majorCode")
    private String majorcode;
    @JsonProperty("majorCodeM")
    private String majorcodem;
    @JsonProperty("majorName")
    private String majorname;
    @JsonProperty("majorNameM")
    private String majornamem;
    @JsonProperty("processId")
    private String processid;
    @JsonProperty("prvId")
    private String prvid;
    @JsonProperty("prvName")
    private String prvname;
    @JsonProperty("regionFullName")
    private String regionfullname;
    @JsonProperty("regionId")
    private String regionid;
    @JsonProperty("regionName")
    private String regionname;
    @JsonProperty("servFactoryCode")
    private String servfactorycode;
    @JsonProperty("servFactoryName")
    private String servfactoryname;
    @JsonProperty("wsBegintime")
    private String wsbegintime;
    @JsonProperty("wsEndtime")
    private String wsendtime;
    @JsonProperty("wsFyPattern")
    private String wsfypattern;
    @JsonProperty("wsHintInfo")
    private String wshintinfo;
    @JsonProperty("wsParentId")
    private String wsparentid;
    @JsonProperty("wsStatusCode")
    private String wsstatuscode;
    @JsonProperty("wsStatusName")
    private String wsstatusname;
    @JsonProperty("wsStatusSn")
    private int wsstatussn;
    @JsonProperty("wsTag")
    private String wstag;
    @JsonProperty("wsTimeoutStatus")
    private String wstimeoutstatus;
    @JsonProperty("wsTimeoutStatusDesc")
    private String wstimeoutstatusdesc;
    @JsonProperty("wsTypeCode")
    private String wstypecode;
    @JsonProperty("wsTypeName")
    private String wstypename;
    private String wsid;
}
