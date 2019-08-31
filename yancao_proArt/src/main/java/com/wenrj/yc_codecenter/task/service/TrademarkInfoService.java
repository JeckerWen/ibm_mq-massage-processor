package com.wenrj.yc_codecenter.task.service;

import com.wenrj.yc_codecenter.task.entity.TrademarkInfo;

public interface TrademarkInfoService {
    void addTrademarkInfo(TrademarkInfo trademarkInfo);

    void saveAndUpdate(TrademarkInfo trademarkInfo);
}
