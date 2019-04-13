package com.aistrong.hnyc_codecenter.common.util;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class FeedBackUtil {
    public static Map feedBackMqp(Map map, String state_code, String state_desc) throws ParseException {
        Map feedBackMap = new HashMap();
        feedBackMap.put("msg_id", map.get("msg_id"));
        feedBackMap.put("state_code", state_code);
        feedBackMap.put("state_desc", state_desc);
        feedBackMap.put("ws_mark", map.get("ws_mark"));
        feedBackMap.put("ws_method", map.get("ws_method"));
        feedBackMap.put("ws_param", map.get("ws_param"));
        feedBackMap.put("curr_time", DateUtil.currTime());
        return feedBackMap;
    }
}
