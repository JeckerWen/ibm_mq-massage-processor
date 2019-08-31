package com.wenrj.yc_codecenter.task.dao;

import com.wenrj.yc_codecenter.task.entity.DeptInfo;

import java.util.List;

public interface DeptInfoDao {
    void addDeptInfo(DeptInfo deptInfo);

    List<DeptInfo> getByDeptCode(String dept_code);

    void updateDeptInfo(DeptInfo deptInfo);
}
