package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.ProvideBealerBaseInfo;

import java.util.List;

public interface ProvideBealerBaseInfoDao {
    void addProvideBealerBaseInfo(ProvideBealerBaseInfo provideBealerBaseInfo);

    List<ProvideBealerBaseInfo> getByProviderCode(String provider_code);

    void updateProvideBealerBaseInfo(ProvideBealerBaseInfo provideBealerBaseInfo);

}
