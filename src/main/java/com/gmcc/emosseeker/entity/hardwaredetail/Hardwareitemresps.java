package com.gmcc.emosseeker.entity.hardwaredetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Hardwareitemresps {
    private String discount;
    @JsonProperty("factoryHandleRemark")
    private String factoryhandleremark;
    @JsonProperty("factoryReturnTime")
    private String factoryreturntime;
    @JsonProperty("handleMail")
    private String handlemail;
    @JsonProperty("handlePhone")
    private String handlephone;
    @JsonProperty("taskId")
    private String taskid;
    private int id;
    private String wsid;
    @JsonProperty("returnPartsCode")
    private String returnpartscode;
    @JsonProperty("taxRate")
    private String taxrate;
    @JsonProperty("amountExcludingTax")
    private String amountexcludingtax;
    @JsonProperty("deliveryCardCode")
    private String deliverycardcode;
    @JsonProperty("factoryOvertimeFlag")
    private String factoryovertimeflag;
    @JsonProperty("returnPartsTime")
    private String returnpartstime;
    @JsonProperty("amountIncludingTax")
    private String amountincludingtax;
    @JsonProperty("receiptTime")
    private String receipttime;
    @JsonProperty("exitInsuranceFlag")
    private int exitinsuranceflag;
    @JsonProperty("returnPartsVersion")
    private String returnpartsversion;
    @JsonProperty("returnPartsBarthday")
    private String returnpartsbarthday;
    @JsonProperty("secondaryRepairFlag")
    private int secondaryrepairflag;
    @JsonProperty("wsStatusName")
    private String wsstatusname;
    private int calculate;
    @JsonProperty("detectionResultDesc")
    private String detectionresultdesc;
    @JsonProperty("panelRegion")
    private String panelregion;
    @JsonProperty("planExcTime")
    private String planexctime;
    @JsonProperty("computerRoomName")
    private String computerroomname;
    @JsonProperty("repairLev")
    private String repairlev;
    @JsonProperty("patsBarthday")
    private String patsbarthday;
    @JsonProperty("computerRoomId")
    private String computerroomid;
    @JsonProperty("servFactoryName")
    private String servfactoryname;
    @JsonProperty("badPatsNetworkNo")
    private String badpatsnetworkno;
    @JsonProperty("incTaxPrice")
    private String inctaxprice;
    @JsonProperty("partsSerialNo")
    private String partsserialno;
    @JsonProperty("excTaxPrice")
    private String exctaxprice;
    @JsonProperty("factoryCase")
    private String factorycase;
    @JsonProperty("faultReason")
    private String faultreason;
    @JsonProperty("exceptionDesc")
    private String exceptiondesc;
    private String remark;
    @JsonProperty("orginFactoryName")
    private String orginfactoryname;
    @JsonProperty("handleUsername")
    private String handleusername;
    @JsonProperty("detectionResult")
    private String detectionresult;
    @JsonProperty("wsParentId")
    private String wsparentid;
    @JsonProperty("handleNetuserid")
    private String handlenetuserid;
    @JsonProperty("pickUpTime")
    private String pickuptime;
    @JsonProperty("returnPartsName")
    private String returnpartsname;
    private String workload;
    @JsonProperty("servFactoryCode")
    private String servfactorycode;
    @JsonProperty("deliveryCardVersion")
    private String deliverycardversion;
    @JsonProperty("returnPartsNoRecord")
    private String returnpartsnorecord;
    @JsonProperty("receiveTime")
    private String receivetime;
    @JsonProperty("wsStatusCode")
    private String wsstatuscode;
    @JsonProperty("orginFactoryCode")
    private String orginfactorycode;
    @JsonProperty("returnPartsSerialNo")
    private String returnpartsserialno;
    @JsonProperty("createTime")
    private String createtime;
    @JsonProperty("deliveryCardName")
    private String deliverycardname;
    @JsonProperty("computerRoom")
    private String computerroom;
}
