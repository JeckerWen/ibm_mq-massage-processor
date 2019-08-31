package com.wenrj.yc_codecenter.common.util;

import com.wenrj.yc_codecenter.system.entity.FeedbackStatus;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class FeedBackUtil {
    public static Map feedBackMqp(Map map, FeedbackStatus fbStatus) throws ParseException {
        Map feedBackMap = new HashMap();
        feedBackMap.put("msg_id", map.get("msg_id"));
        feedBackMap.put("state_code", fbStatus.getStatusCode());
        feedBackMap.put("state_desc", fbStatus.getDesc());
        feedBackMap.put("ws_mark", map.get("ws_mark"));
        feedBackMap.put("ws_method", map.get("ws_method"));
        feedBackMap.put("ws_param", map.get("ws_param"));
        feedBackMap.put("curr_time", DateUtil.currTime());
        return feedBackMap;
    }
}
