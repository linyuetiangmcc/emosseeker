package com.gmcc.emosseeker.entity.hardwaredetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmcc.emosseeker.entity.Basehandlerecresps;
import com.gmcc.emosseeker.entity.Baseworksheetresp;
import lombok.Data;

import java.util.List;
@Data
public class DataDetailHardWare {
    @JsonProperty("baseAttachResps")
    private List<Object> baseattachresps;
    @JsonProperty("baseHandleRecResps")
    private List<Basehandlerecresps> basehandlerecresps;
    @JsonProperty("baseWorksheetResp")
    private Baseworksheetresp baseworksheetresp;
    @JsonProperty("hardwareItemResps")
    private List<Hardwareitemresps> hardwareitemresps;
    @JsonProperty("hardwareRepairWorksheetResp")
    private Hardwarerepairworksheetresp hardwarerepairworksheetresp;
    @JsonProperty("queryAuditRecordRespList")
    private List<String> queryauditrecordresplist;
    @JsonProperty("replyRecResps")
    private List<String> replyrecresps;
    @JsonProperty("taskId")
    private String taskid;
    @JsonProperty("wsSignInfos")
    private List<String> wssigninfos;
}
