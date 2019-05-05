package com.aistrong.hnyc_codecenter.task.entity;

import java.sql.Timestamp;
import java.util.Date;

public class HeadInfo {
    private String msg_id;
    private String ws_mark;
    private String ws_method;
    private String ws_param;
    private Timestamp recv_time;
    private Timestamp curr_time;
    private String curr_user;
    private String recv_info;

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

    public Timestamp getRecv_time() {
        return recv_time;
    }

    public void setRecv_time(Timestamp recv_time) {
        this.recv_time = recv_time;
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

    public String getRecv_info() {
        return recv_info;
    }

    public void setRecv_info(String recv_info) {
        this.recv_info = recv_info;
    }
}
