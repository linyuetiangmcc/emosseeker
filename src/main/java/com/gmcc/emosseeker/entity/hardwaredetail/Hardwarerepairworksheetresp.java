package com.gmcc.emosseeker.entity.hardwaredetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Hardwarerepairworksheetresp {
    private String wsid;
    @JsonProperty("archivedDesc")
    private String archiveddesc;
    @JsonProperty("lastAuditMail")
    private String lastauditmail;
    private String id;
    @JsonProperty("serviceContent")
    private String servicecontent;
    @JsonProperty("repairCount")
    private String repaircount;
    @JsonProperty("lastAuditResult")
    private String lastauditresult;
    @JsonProperty("serviceIsComplete")
    private String serviceiscomplete;
    @JsonProperty("amountExcludingTax")
    private String amountexcludingtax;
    @JsonProperty("serviceConfirmUsername")
    private String serviceconfirmusername;
    @JsonProperty("factoryReceiveUser")
    private String factoryreceiveuser;
    @JsonProperty("majorCodeM")
    private String majorcodem;
    @JsonProperty("acceptDesc")
    private String acceptdesc;
    @JsonProperty("leftProblem")
    private String leftproblem;
    @JsonProperty("lastAuditUsername")
    private String lastauditusername;
    @JsonProperty("acceptPhone")
    private String acceptphone;
    @JsonProperty("equipmentTypeCode")
    private String equipmenttypecode;
    private String description;
    @JsonProperty("amountIncludingTax")
    private String amountincludingtax;
    @JsonProperty("equipmentTypeName")
    private String equipmenttypename;
    @JsonProperty("handleLimitTime")
    private String handlelimittime;
    @JsonProperty("majorNameM")
    private String majornamem;
    @JsonProperty("prvId")
    private String prvid;
    @JsonProperty("receiptTime")
    private String receipttime;
    @JsonProperty("serviceSatisfaction")
    private String servicesatisfaction;
    @JsonProperty("acceptUsername")
    private String acceptusername;
    @JsonProperty("wsStatusName")
    private String wsstatusname;
    @JsonProperty("acceptMail")
    private String acceptmail;
    @JsonProperty("acceptEndTime")
    private String acceptendtime;
    @JsonProperty("repairLev")
    private String repairlev;
    @JsonProperty("conStatus")
    private String constatus;
    @JsonProperty("lastAuditPhone")
    private String lastauditphone;
    @JsonProperty("lastUpdateTime")
    private String lastupdatetime;
    @JsonProperty("isResolve")
    private String isresolve;
    @JsonProperty("archivedTime")
    private String archivedtime;
    @JsonProperty("repairDate")
    private String repairdate;
    @JsonProperty("servFactoryName")
    private String servfactoryname;
    @JsonProperty("customerAddress")
    private String customeraddress;
    @JsonProperty("serviceConfirmMail")
    private String serviceconfirmmail;
    @JsonProperty("serviceConfirmOpinoin")
    private String serviceconfirmopinoin;
    @JsonProperty("acceptLimitTime")
    private String acceptlimittime;
    @JsonProperty("regionId")
    private String regionid;
    @JsonProperty("conEndDate")
    private String conenddate;
    @JsonProperty("serviceConfirmPhone")
    private String serviceconfirmphone;
    @JsonProperty("conCode")
    private String concode;
    private String evaluate;
    @JsonProperty("attachNeedFlag")
    private int attachneedflag;
    @JsonProperty("majorName")
    private String majorname;
    @JsonProperty("prvName")
    private String prvname;
    @JsonProperty("conCreateDate")
    private String concreatedate;
    @JsonProperty("wsAuditStatusCode")
    private String wsauditstatuscode;
    @JsonProperty("conName")
    private String conname;
    @JsonProperty("pickUpTime")
    private String pickuptime;
    @JsonProperty("serviceConfirmNetuserid")
    private String serviceconfirmnetuserid;
    @JsonProperty("regionName")
    private String regionname;
    @JsonProperty("servFactoryCode")
    private String servfactorycode;
    @JsonProperty("factoryReceivePhone")
    private String factoryreceivephone;
    @JsonProperty("wsAuditStatusName")
    private String wsauditstatusname;
    @JsonProperty("conStartDate")
    private String constartdate;
    @JsonProperty("deductionReason")
    private String deductionreason;
    @JsonProperty("receiveTime")
    private String receivetime;
    @JsonProperty("wsStatusCode")
    private String wsstatuscode;
    @JsonProperty("factoryReceiveAddress")
    private String factoryreceiveaddress;
    @JsonProperty("lastAuditNetuserid")
    private String lastauditnetuserid;
    @JsonProperty("majorCode")
    private String majorcode;
    @JsonProperty("postalCode")
    private String postalcode;
    @JsonProperty("conFyPatternName")
    private String confypatternname;
    @JsonProperty("lastAuditAdvice")
    private String lastauditadvice;
    @JsonProperty("acceptNetuserid")
    private String acceptnetuserid;
}
