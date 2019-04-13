package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.ProvideBealerBaseInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.ProvideBealerBaseInfo;
import com.aistrong.hnyc_codecenter.task.service.ProvideBealerBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvideBealerBaseInfoImpl implements ProvideBealerBaseInfoService {
    @Autowired
    ProvideBealerBaseInfoDao provideBealerBaseInfoDao;

    @Override
    public void addProvideBealerBaseInfo(ProvideBealerBaseInfo provideBealerBaseInfo) {
        provideBealerBaseInfoDao.addProvideBealerBaseInfo(provideBealerBaseInfo);
    }

    @Override
    public void saveAndUpdate(ProvideBealerBaseInfo provideBealerBaseInfo) {
        List<ProvideBealerBaseInfo> list = new ArrayList<ProvideBealerBaseInfo>();
        list = provideBealerBaseInfoDao.getByProviderCode(provideBealerBaseInfo.getProvider_code());
        if (list.size() > 0) {
            provideBealerBaseInfoDao.updateProvideBealerBaseInfo(provideBealerBaseInfo);
        } else {
            provideBealerBaseInfoDao.addProvideBealerBaseInfo(provideBealerBaseInfo);
        }
    }
}
