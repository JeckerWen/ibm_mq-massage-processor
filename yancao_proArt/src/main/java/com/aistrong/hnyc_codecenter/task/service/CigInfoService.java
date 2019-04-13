package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.CigInfo;

public interface CigInfoService {
    public void addCigInfo(CigInfo cigInfo);

    public void saveAndUpdate(CigInfo cigInfo);
}
