package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.LeafBreedInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.LeafBreedInfo;
import com.aistrong.hnyc_codecenter.task.service.LeafBreedInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeafBreedInfoImpl implements LeafBreedInfoService {
    @Autowired
    LeafBreedInfoDao leafBreedInfoDao;

    @Override
    public void addLeafBreedInfo(LeafBreedInfo leafBreedInfo) {
        leafBreedInfoDao.addLeafBreedInfo(leafBreedInfo);
    }
}
