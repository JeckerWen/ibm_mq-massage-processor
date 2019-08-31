package com.wenrj.yc_codecenter.task.service;

import com.wenrj.yc_codecenter.task.entity.CigInfo;

public interface CigInfoService {
    void addCigInfo(CigInfo cigInfo);

    void saveAndUpdate(CigInfo cigInfo);
}
