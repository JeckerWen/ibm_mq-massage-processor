package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.DeptInfo;

public interface DeptInfoService {
    void addDeptInfo(DeptInfo deptInfo);

    void saveAndUpdate(DeptInfo deptInfo);
}
