package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.HeadInfo;

import java.util.List;

public interface HeadInfoDao {
    public void addHeadInfo(HeadInfo headInfo);

    public List<HeadInfo> getByMsgId(String msg_id);

    public void updateHeadInfo(HeadInfo headInfo);
}
