package com.wenrj.yc_codecenter.system.entity;

public class FeedbackStatus {

    private String statusCode;

    private String desc;

    private String type;

    @Override
    public String toString() {
        return "状态码:" + this.statusCode + " 状态描述:" + this.desc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
