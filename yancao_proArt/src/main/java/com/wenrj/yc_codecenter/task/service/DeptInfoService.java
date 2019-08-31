package com.wenrj.yc_codecenter.task.service;

import com.wenrj.yc_codecenter.task.entity.DeptInfo;

public interface DeptInfoService {
    void addDeptInfo(DeptInfo deptInfo);

    void saveAndUpdate(DeptInfo deptInfo);
}
