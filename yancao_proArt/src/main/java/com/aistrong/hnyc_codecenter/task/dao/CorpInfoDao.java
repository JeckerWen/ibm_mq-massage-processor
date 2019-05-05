package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.CorpInfo;

import java.util.List;

public interface CorpInfoDao {
    void addCorpInfo(CorpInfo corpInfo);

    List<CorpInfo> getByCorpCode(String corp_code);

    void updateCorpInfo(CorpInfo corpInfo);
}
