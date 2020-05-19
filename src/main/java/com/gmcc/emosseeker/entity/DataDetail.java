package com.gmcc.emosseeker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class DataDetail {
    @JsonProperty("baseAttachResps")
    private List<String> baseattachresps;
    @JsonProperty("baseHandleRecResps")
    private List<Basehandlerecresps> basehandlerecresps;
    @JsonProperty("baseWorksheetResp")
    private Baseworksheetresp baseworksheetresp;
    @JsonProperty("queryAuditRecordRespList")
    private List<String> queryauditrecordresplist;
    @JsonProperty("replyRecResps")
    private List<String> replyrecresps;
    @JsonProperty("sceneServiceWorksheetResp")
    private Sceneserviceworksheetresp sceneserviceworksheetresp;
    @JsonProperty("taskId")
    private String taskid;
    @JsonProperty("wsSceneServiceMatterRespList")
    private List<Wssceneservicematterresplist> wssceneservicematterresplist;
    @JsonProperty("wsSignInfos")
    private List<String> wssigninfos;
}
