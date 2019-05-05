package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.RegionalismInfo;

import java.util.List;

public interface RegionalismInfoDao {
    void addRegionalismInfo(RegionalismInfo regionalismInfo);

    List<RegionalismInfo> getByRegionalismCode(String regionalism_code);

    void updateRegionalismInfo(RegionalismInfo regionalismInfo);

}
