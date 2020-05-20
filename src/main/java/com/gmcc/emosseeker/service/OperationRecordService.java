package com.gmcc.emosseeker.service;

import com.gmcc.emosseeker.dbentity.OperationRecord;

import java.util.List;

public interface OperationRecordService {
    OperationRecord queryOperationRecordById(Integer id);
    List<OperationRecord> queryOperationRecordByUserId(Integer userId);
    boolean insertOperationRecord(OperationRecord OperationRecord);
    boolean deleteOperationRecordById(Integer id);
}