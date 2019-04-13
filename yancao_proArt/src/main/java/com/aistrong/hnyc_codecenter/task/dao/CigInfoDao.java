package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.CigInfo;

import java.util.List;

public interface CigInfoDao {
    public void addCigInfo(CigInfo cigInfo);

    public List<CigInfo> getByCigCode(String cig_code);

    public void updateCigInfo(CigInfo cigInfo);


}
