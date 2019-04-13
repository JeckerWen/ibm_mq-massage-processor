package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.CigInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.CigInfo;
import com.aistrong.hnyc_codecenter.task.service.CigInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CigInfoImpl implements CigInfoService {
    @Autowired
    CigInfoDao cigInfoDao;

    @Override
    public void addCigInfo(CigInfo cigInfo) {
        cigInfoDao.addCigInfo(cigInfo);
    }

    @Override
    public void saveAndUpdate(CigInfo cigInfo) {
        List<CigInfo> list = new ArrayList<CigInfo>();
        list = cigInfoDao.getByCigCode(cigInfo.getCig_code());
        if (list.size() > 0) {
            cigInfoDao.updateCigInfo(cigInfo);
        } else {
            cigInfoDao.addCigInfo(cigInfo);
        }
    }
}
