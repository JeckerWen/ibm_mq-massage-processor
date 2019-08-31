package com.wenrj.yc_codecenter.task.dao;

import com.wenrj.yc_codecenter.task.entity.ProvideBealerBaseInfo;

import java.util.List;

public interface ProvideBealerBaseInfoDao {
    void addProvideBealerBaseInfo(ProvideBealerBaseInfo provideBealerBaseInfo);

    List<ProvideBealerBaseInfo> getByProviderCode(String provider_code);

    void updateProvideBealerBaseInfo(ProvideBealerBaseInfo provideBealerBaseInfo);

}
