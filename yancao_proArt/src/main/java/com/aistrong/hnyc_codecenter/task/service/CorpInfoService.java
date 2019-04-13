package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.CorpInfo;

public interface CorpInfoService {
    public void addCorpInfo(CorpInfo corpInfo);

    public void saveAndUpdate(CorpInfo corpInfo);
}
