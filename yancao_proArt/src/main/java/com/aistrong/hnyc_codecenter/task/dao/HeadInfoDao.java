package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.HeadInfo;

import java.util.List;

public interface HeadInfoDao {
    void addHeadInfo(HeadInfo headInfo);

    List<HeadInfo> getByMsgId(String msg_id);

    void updateHeadInfo(HeadInfo headInfo);
}
