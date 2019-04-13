package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.HeadInfo;

public interface HeadInfoService {
    public void addHeadInfo(HeadInfo Headinfo);

    public boolean getByMsgId(String msg_id);

    public void updateHeadInfo(HeadInfo headInfo);
}
