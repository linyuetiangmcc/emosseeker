package com.gmcc.emosseeker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wssceneservicematterresplist {
    @JsonProperty("computerArrive")
    private int computerarrive;
    @JsonProperty("computerRoomId")
    private String computerroomid;
    @JsonProperty("computerRoomName")
    private String computerroomname;
    private String id;
    @JsonProperty("matterExplain")
    private String matterexplain;
    private String wsid;
}
