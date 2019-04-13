package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.TrademarkInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.TrademarkInfo;
import com.aistrong.hnyc_codecenter.task.service.TrademarkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrademarkInfoImpl implements TrademarkInfoService {
    @Autowired
    TrademarkInfoDao trademarkInfoDao;

    @Override
    public void addTrademarkInfo(TrademarkInfo trademarkInfo) {
        trademarkInfoDao.addTrademarkInfo(trademarkInfo);
    }

    @Override
    public void saveAndUpdate(TrademarkInfo trademarkInfo) {
        List<TrademarkInfo> list = new ArrayList<TrademarkInfo>();
        list = trademarkInfoDao.getByTrademarkCode(trademarkInfo.getTrademark_code());
        if (list.size() > 0) {
            trademarkInfoDao.updateTrademarkInfo(trademarkInfo);
        } else {
            trademarkInfoDao.addTrademarkInfo(trademarkInfo);
        }
    }

}
