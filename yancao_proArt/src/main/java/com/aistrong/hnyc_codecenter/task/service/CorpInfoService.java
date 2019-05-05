package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.CorpInfo;

public interface CorpInfoService {
    void addCorpInfo(CorpInfo corpInfo);

    void saveAndUpdate(CorpInfo corpInfo);
}
