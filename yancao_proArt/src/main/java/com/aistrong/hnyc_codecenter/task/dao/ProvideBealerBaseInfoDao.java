package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.ProvideBealerBaseInfo;

import java.util.List;

public interface ProvideBealerBaseInfoDao {
    public void addProvideBealerBaseInfo(ProvideBealerBaseInfo provideBealerBaseInfo);

    public List<ProvideBealerBaseInfo> getByProviderCode(String provider_code);

    public void updateProvideBealerBaseInfo(ProvideBealerBaseInfo provideBealerBaseInfo);

}
