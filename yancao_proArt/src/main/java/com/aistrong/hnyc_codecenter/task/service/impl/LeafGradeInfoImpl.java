package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.LeafGradeInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.LeafGradeInfo;
import com.aistrong.hnyc_codecenter.task.service.LeafGradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeafGradeInfoImpl implements LeafGradeInfoService {
    @Autowired
    LeafGradeInfoDao leafGradeInfoDao;

    @Override
    public void addLeafGradeInfo(LeafGradeInfo leafGradeInfo) {
        leafGradeInfoDao.addLeafGradeInfo(leafGradeInfo);
    }
}
