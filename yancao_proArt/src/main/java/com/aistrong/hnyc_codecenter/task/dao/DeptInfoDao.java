package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.DeptInfo;

import java.util.List;

public interface DeptInfoDao {
    public void addDeptInfo(DeptInfo deptInfo);

    public List<DeptInfo> getByDeptCode(String dept_code);

    public void updateDeptInfo(DeptInfo deptInfo);
}
