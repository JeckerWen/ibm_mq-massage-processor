package com.wenrj.yc_codecenter.task.dao;

import com.wenrj.yc_codecenter.task.entity.CorpInfo;

import java.util.List;

public interface CorpInfoDao {
    void addCorpInfo(CorpInfo corpInfo);

    List<CorpInfo> getByCorpCode(String corp_code);

    void updateCorpInfo(CorpInfo corpInfo);
}
