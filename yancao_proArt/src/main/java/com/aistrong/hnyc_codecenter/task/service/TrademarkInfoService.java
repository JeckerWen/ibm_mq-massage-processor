package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.TrademarkInfo;

public interface TrademarkInfoService {
    void addTrademarkInfo(TrademarkInfo trademarkInfo);

    void saveAndUpdate(TrademarkInfo trademarkInfo);
}
