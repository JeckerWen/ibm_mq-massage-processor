package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.TrademarkInfo;

public interface TrademarkInfoService {
    public void addTrademarkInfo(TrademarkInfo trademarkInfo);

    public void saveAndUpdate(TrademarkInfo trademarkInfo);
}
