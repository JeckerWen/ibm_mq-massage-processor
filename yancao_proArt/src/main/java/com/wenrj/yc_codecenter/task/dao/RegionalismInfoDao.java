package com.wenrj.yc_codecenter.task.dao;

import com.wenrj.yc_codecenter.task.entity.RegionalismInfo;

import java.util.List;

public interface RegionalismInfoDao {
    void addRegionalismInfo(RegionalismInfo regionalismInfo);

    List<RegionalismInfo> getByRegionalismCode(String regionalism_code);

    void updateRegionalismInfo(RegionalismInfo regionalismInfo);

}
