package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.LeafTypeInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.LeafTypeInfo;
import com.aistrong.hnyc_codecenter.task.service.LeafTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeafTypeInfoImpl implements LeafTypeInfoService {

    @Autowired
    LeafTypeInfoDao leafTypeInfoDao;

    @Override
    public void addLeafTypeInfo(LeafTypeInfo leafTypeInfo) {
        leafTypeInfoDao.addLeafTypeInfo(leafTypeInfo);
    }
}
