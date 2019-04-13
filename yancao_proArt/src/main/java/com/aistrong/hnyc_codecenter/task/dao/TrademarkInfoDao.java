package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.TrademarkInfo;

import java.util.List;

public interface TrademarkInfoDao {
    public void addTrademarkInfo(TrademarkInfo trademarkInfo);

    public List<TrademarkInfo> getByTrademarkCode(String trademark_code);

    public void updateTrademarkInfo(TrademarkInfo trademarkInfo);

}
