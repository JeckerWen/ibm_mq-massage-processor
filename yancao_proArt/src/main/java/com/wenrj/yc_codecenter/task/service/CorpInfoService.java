package com.wenrj.yc_codecenter.task.service;

import com.wenrj.yc_codecenter.task.entity.CorpInfo;

public interface CorpInfoService {
    void addCorpInfo(CorpInfo corpInfo);

    void saveAndUpdate(CorpInfo corpInfo);
}
