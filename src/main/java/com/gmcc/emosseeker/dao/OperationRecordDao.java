package com.gmcc.emosseeker.dao;

import com.gmcc.emosseeker.dbentity.OperationRecord;
import com.gmcc.emosseeker.dbentity.UserInfo;

import java.util.List;

public interface OperationRecordDao {
    OperationRecord queryOperationRecordById(Integer id);
    List<OperationRecord> queryOperationRecordByUserId(Integer userId);
    int insertOperationRecord(OperationRecord OperationRecord);
    int deleteOperationRecordById(Integer id);
}
