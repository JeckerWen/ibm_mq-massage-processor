package com.wenrj.yc_codecenter.task.service.impl;

import com.wenrj.yc_codecenter.task.dao.HeadInfoDao;
import com.wenrj.yc_codecenter.task.entity.HeadInfo;
import com.wenrj.yc_codecenter.task.service.HeadInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeadInfoImpl implements HeadInfoService {
    @Autowired
    HeadInfoDao headInfoDao;

    @Override
    public void addHeadInfo(HeadInfo headInfo) {
        headInfoDao.addHeadInfo(headInfo);
    }

    @Override
    public void saveAndUpdate(HeadInfo headInfo) {
        List<HeadInfo> list = new ArrayList<>();
        list = headInfoDao.getByMsgId(headInfo.getMsg_id());
        if (list.size() > 0) {
            headInfoDao.updateHeadInfo(headInfo);
        } else {
            headInfoDao.addHeadInfo(headInfo);
        }
    }
}
