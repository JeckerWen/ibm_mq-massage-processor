package com.wenrj.yc_codecenter.task.service.impl;

import com.wenrj.yc_codecenter.task.dao.LeafTypeInfoDao;
import com.wenrj.yc_codecenter.task.entity.LeafTypeInfo;
import com.wenrj.yc_codecenter.task.service.LeafTypeInfoService;
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
