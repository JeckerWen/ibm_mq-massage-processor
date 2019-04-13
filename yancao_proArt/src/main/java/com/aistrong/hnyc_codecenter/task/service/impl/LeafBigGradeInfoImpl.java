package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.LeafBigGradeInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.LeafBigGradeInfo;
import com.aistrong.hnyc_codecenter.task.service.LeafBigGradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeafBigGradeInfoImpl implements LeafBigGradeInfoService {
    @Autowired
    LeafBigGradeInfoDao leafBigGradeInfoDao;

    @Override
    public void addLeafBigGradeInfo(LeafBigGradeInfo leafBigGradeInfo) {
        leafBigGradeInfoDao.addLeafBigGradeInfo(leafBigGradeInfo);
    }
}
