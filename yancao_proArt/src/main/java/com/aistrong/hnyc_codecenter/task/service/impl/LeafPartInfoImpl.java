package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.LeafPartInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.LeafPartInfo;
import com.aistrong.hnyc_codecenter.task.service.LeafPartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeafPartInfoImpl implements LeafPartInfoService {
    @Autowired
    LeafPartInfoDao leafPartInfoDao;

    @Override
    public void addLeafPartInfo(LeafPartInfo leafPartInfo){
        leafPartInfoDao.addLeafPartInfo(leafPartInfo);
    }

}
