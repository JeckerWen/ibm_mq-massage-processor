package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.CigInfo;

public interface CigInfoService {
    void addCigInfo(CigInfo cigInfo);

    void saveAndUpdate(CigInfo cigInfo);
}
