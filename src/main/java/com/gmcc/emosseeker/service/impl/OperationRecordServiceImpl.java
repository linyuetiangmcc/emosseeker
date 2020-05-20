package com.gmcc.emosseeker.service.impl;

import com.gmcc.emosseeker.dao.OperationRecordDao;
import com.gmcc.emosseeker.dbentity.OperationRecord;
import com.gmcc.emosseeker.service.OperationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OperationRecordServiceImpl implements OperationRecordService {
    @Autowired
    private OperationRecordDao operationRecordDao;

    @Override
    public OperationRecord queryOperationRecordById(Integer id) {
        return operationRecordDao.queryOperationRecordById(id);
    }

    @Override
    public List<OperationRecord> queryOperationRecordByUserId(Integer userId) {
        return operationRecordDao.queryOperationRecordByUserId(userId);
    }

    @Override
    public boolean insertOperationRecord(OperationRecord operationRecord) {
        int effectNumber = operationRecordDao.insertOperationRecord(operationRecord);
        if(effectNumber == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteOperationRecordById(Integer id) {
        int effectNumber = operationRecordDao.deleteOperationRecordById(id);
        if(effectNumber == 1)
            return true;
        else
            return false;
    }
}
