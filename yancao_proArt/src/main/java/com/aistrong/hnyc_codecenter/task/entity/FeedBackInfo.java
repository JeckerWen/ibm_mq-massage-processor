package com.aistrong.hnyc_codecenter.task.entity;

import java.sql.Timestamp;
import java.util.Date;

public class FeedBackInfo {
    private String msg_id;
    private String state_code;
    private String state_desc;
    private String ws_mark;
    private String ws_method;
    private String ws_param;
    private Timestamp curr_time;
    private String send_content;

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getState_desc() {
        return state_desc;
    }

    public void setState_desc(String state_desc) {
        this.state_desc = state_desc;
    }

    public String getWs_mark() {
        return ws_mark;
    }

    public void setWs_mark(String ws_mark) {
        this.ws_mark = ws_mark;
    }

    public String getWs_method() {
        return ws_method;
    }

    public void setWs_method(String ws_method) {
        this.ws_method = ws_method;
    }

    public String getWs_param() {
        return ws_param;
    }

    public void setWs_param(String ws_param) {
        this.ws_param = ws_param;
    }

    public Timestamp getCurr_time() {
        return curr_time;
    }

    public void setCurr_time(Timestamp curr_time) {
        this.curr_time = curr_time;
    }

    public String getSend_content() {
        return send_content;
    }

    public void setSend_content(String send_content) {
        this.send_content = send_content;
    }
}
