package com.gmcc.emosseeker.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class Basehandlerecresps {
    @JsonProperty("handleContent")
    private String handlecontent;
    @JsonProperty("handleNetuserid")
    private String handlenetuserid;
    @JsonProperty("handleResult")
    private int handleresult;
    @JsonProperty("handleTime")
    private String handletime;
    @JsonProperty("handleTypeCode")
    private String handletypecode;
    @JsonProperty("handleTypeName")
    private String handletypename;
    @JsonProperty("handleUsername")
    private String handleusername;
    private String id;
    @JsonProperty("processId")
    private String processid;
    private String wsid;
}
