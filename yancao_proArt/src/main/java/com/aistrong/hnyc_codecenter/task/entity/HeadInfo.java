package com.aistrong.hnyc_codecenter.task.entity;

import java.sql.Timestamp;
import java.util.Date;

public class HeadInfo {
    private String msg_id;
    private String ws_mark;
    private String ws_method;
    private String ws_param;
    private Timestamp curr_time;
    private String curr_user;
    private String rece_info;

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
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

    public String getCurr_user() {
        return curr_user;
    }

    public void setCurr_user(String curr_user) {
        this.curr_user = curr_user;
    }

    public String getRece_info() {
        return rece_info;
    }

    public void setRece_info(String rece_info) {
        this.rece_info = rece_info;
    }
}
