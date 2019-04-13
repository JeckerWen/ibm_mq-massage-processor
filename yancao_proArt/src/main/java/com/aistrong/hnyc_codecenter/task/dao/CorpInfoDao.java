package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.CorpInfo;

import java.util.List;

public interface CorpInfoDao {
    public void addCorpInfo(CorpInfo corpInfo);

    public List<CorpInfo> getByCorpCode(String corp_code);

    public void updateCorpInfo(CorpInfo corpInfo);
}
