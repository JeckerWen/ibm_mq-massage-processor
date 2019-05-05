package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.CorpInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.CorpInfo;
import com.aistrong.hnyc_codecenter.task.service.CorpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorpInfoImpl implements CorpInfoService {
    @Autowired
    CorpInfoDao corpInfoDao;

    @Override
    public void addCorpInfo(CorpInfo corpInfo) {
        corpInfoDao.addCorpInfo(corpInfo);
    }

    @Override
    public void saveAndUpdate(CorpInfo corpInfo) {
        List<CorpInfo> list = new ArrayList<CorpInfo>();
        list = corpInfoDao.getByCorpCode(corpInfo.getDept_code());
        if (list.size() > 0) {
            corpInfoDao.updateCorpInfo(corpInfo);
        } else {
            corpInfoDao.addCorpInfo(corpInfo);
        }
    }
}
