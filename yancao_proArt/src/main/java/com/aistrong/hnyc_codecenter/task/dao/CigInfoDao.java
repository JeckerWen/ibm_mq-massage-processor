package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.CigInfo;

import java.util.List;

public interface CigInfoDao {
    void addCigInfo(CigInfo cigInfo);

    List<CigInfo> getByCigCode(String cig_code);

    void updateCigInfo(CigInfo cigInfo);


}
