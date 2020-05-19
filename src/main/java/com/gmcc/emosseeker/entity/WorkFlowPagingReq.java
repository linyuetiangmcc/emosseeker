package com.gmcc.emosseeker.entity;

import lombok.Data;

@Data
public class WorkFlowPagingReq {
    private  Integer pageNumber;
    private  Integer size;
    private  Integer startNumber;
    private  Integer total;
}
