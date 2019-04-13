package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.FeedBackInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.FeedBackInfo;
import com.aistrong.hnyc_codecenter.task.service.FeedBackInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackInfoImpl implements FeedBackInfoService {

    @Autowired
    FeedBackInfoDao feedBackInfoDao;

    @Override
    public void addFeedBackInfo(FeedBackInfo feedBackInfo) {
        feedBackInfoDao.addFeedBackInfo(feedBackInfo);
    }
}
