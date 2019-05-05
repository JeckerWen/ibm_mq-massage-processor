package com.aistrong.hnyc_codecenter.task.entity;

import java.sql.Timestamp;

public class DeptInfo {
    private String dept_code;
    private String dept_name;
    private String dept_full_name;
    private String dept_in_corp;
    private String super_dept_code;
    private String dept_type;
    private String status;
    private String code_purview;
    private String code_gbm;
    private String code_level;
    private String code_leaf;
    private String code_order;
    private String view_code;
    private String creator;
    private Timestamp create_time;
    private String modifier;
    private Timestamp modifytime;

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

    public String getCode_purview() {
        return code_purview;
    }

    public void setCode_purview(String code_purview) {
        this.code_purview = code_purview;
    }

    public String getCode_gbm() {
        return code_gbm;
    }

    public void setCode_gbm(String code_gbm) {
        this.code_gbm = code_gbm;
    }

    public String getCode_level() {
        return code_level;
    }

    public void setCode_level(String code_level) {
        this.code_level = code_level;
    }

    public String getCode_leaf() {
        return code_leaf;
    }

    public void setCode_leaf(String code_leaf) {
        this.code_leaf = code_leaf;
    }

    public String getCode_order() {
        return code_order;
    }

    public void setCode_order(String code_order) {
        this.code_order = code_order;
    }

    public String getView_code() {
        return view_code;
    }

    public void setView_code(String view_code) {
        this.view_code = view_code;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }



    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getModifytime() {
        return modifytime;
    }

    public void setModifytime(Timestamp modifytime) {
        this.modifytime = modifytime;
    }
}
