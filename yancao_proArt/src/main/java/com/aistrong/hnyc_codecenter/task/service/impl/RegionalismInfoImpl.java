package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.RegionalismInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.RegionalismInfo;
import com.aistrong.hnyc_codecenter.task.service.RegionalismInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionalismInfoImpl implements RegionalismInfoService {
    @Autowired
    RegionalismInfoDao regionalismInfoDao;

    @Override
    public void addRegionalismInfo(RegionalismInfo regionalismInfo) {
        regionalismInfoDao.addRegionalismInfo(regionalismInfo);
    }

    @Override
    public void saveAndUpdate(RegionalismInfo regionalismInfo) {
        List<RegionalismInfo> list = new ArrayList<RegionalismInfo>();
        list = regionalismInfoDao.getByRegionalismCode(regionalismInfo.getRegionalism_code());
        if (list.size() > 0) {
            regionalismInfoDao.updateRegionalismInfo(regionalismInfo);
        } else {
            regionalismInfoDao.addRegionalismInfo(regionalismInfo);
        }
    }
}
