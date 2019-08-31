package com.wenrj.yc_codecenter.task.dao;

import com.wenrj.yc_codecenter.task.entity.TrademarkInfo;

import java.util.List;

public interface TrademarkInfoDao {
    void addTrademarkInfo(TrademarkInfo trademarkInfo);

    List<TrademarkInfo> getByTrademarkCode(String trademark_code);

    void updateTrademarkInfo(TrademarkInfo trademarkInfo);

}
