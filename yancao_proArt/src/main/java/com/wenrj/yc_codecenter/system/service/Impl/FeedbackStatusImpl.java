package com.wenrj.yc_codecenter.system.service.Impl;

import com.wenrj.yc_codecenter.system.dao.FeedbackStatusDao;
import com.wenrj.yc_codecenter.system.entity.FeedbackStatus;
import com.wenrj.yc_codecenter.system.service.FeedbackStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackStatusImpl implements FeedbackStatusService {
    @Autowired
    private FeedbackStatusDao feedbackStatusDao;

    @Override
    public List<FeedbackStatus> getAllFeedBackStatus() {
        List<FeedbackStatus> list = new ArrayList<>();
        try {
            list = feedbackStatusDao.getAllFeedBackStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
