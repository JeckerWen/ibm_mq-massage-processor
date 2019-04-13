package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.RegionalismInfo;

import java.util.List;

public interface RegionalismInfoDao {
    public void addRegionalismInfo(RegionalismInfo regionalismInfo);

    public List<RegionalismInfo> getByRegionalismCode(String regionalism_code);

    public void updateRegionalismInfo(RegionalismInfo regionalismInfo);

}
