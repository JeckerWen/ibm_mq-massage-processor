package com.wenrj.yc_codecenter.task.dao;

import com.wenrj.yc_codecenter.task.entity.HeadInfo;

import java.util.List;

public interface HeadInfoDao {
    void addHeadInfo(HeadInfo headInfo);

    List<HeadInfo> getByMsgId(String msg_id);

    void updateHeadInfo(HeadInfo headInfo);
}
