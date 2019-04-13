package com.aistrong.hnyc_codecenter.task.entity;

public class DeptInfo {
    private String dept_code;
    private String dept_name;
    private String dept_full_name;
    private String dept_in_corp;
    private String super_dept_code;
    private String dept_type;
    private String status;

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_full_name() {
        return dept_full_name;
    }

    public void setDept_full_name(String dept_full_name) {
        this.dept_full_name = dept_full_name;
    }

    public String getDept_in_corp() {
        return dept_in_corp;
    }

    public void setDept_in_corp(String dept_in_corp) {
        this.dept_in_corp = dept_in_corp;
    }

    public String getSuper_dept_code() {
        return super_dept_code;
    }

    public void setSuper_dept_code(String super_dept_code) {
        this.super_dept_code = super_dept_code;
    }

    public String getDept_type() {
        return dept_type;
    }

    public void setDept_type(String dept_type) {
        this.dept_type = dept_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
