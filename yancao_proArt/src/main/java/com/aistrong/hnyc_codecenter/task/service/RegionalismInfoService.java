package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.RegionalismInfo;

public interface RegionalismInfoService {
    void addRegionalismInfo(RegionalismInfo regionalismInfo);

    void saveAndUpdate(RegionalismInfo regionalismInfo);
}
