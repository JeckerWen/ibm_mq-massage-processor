package com.aistrong.hnyc_codecenter.task.service.impl;

import com.aistrong.hnyc_codecenter.task.dao.HeadInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.HeadInfo;
import com.aistrong.hnyc_codecenter.task.service.HeadInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadInfoServiceImpl implements HeadInfoService {
    @Autowired
    HeadInfoDao headInfoDao;

    @Override
    public void addHeadInfo(HeadInfo headInfo) {
        headInfoDao.addHeadInfo(headInfo);
    }

    @Override
    public boolean getByMsgId(String msg_id) {
        HeadInfo headInfo = new HeadInfo();
        List<HeadInfo> list = headInfoDao.getByMsgId(msg_id);
        if (list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void updateHeadInfo(HeadInfo headInfo) {
        try {
            headInfoDao.updateHeadInfo(headInfo);
        } catch (Exception e) {
            System.out.println("更新headInfo失败, msg_id为:" + headInfo.getMsg_id());
            e.printStackTrace();
        }
    }
}
