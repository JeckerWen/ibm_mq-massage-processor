package com.wenrj.yc_codecenter.task.service;

import com.wenrj.yc_codecenter.task.entity.EmployeeInfo;

public interface EmployeeInfoService {
    void addEmployeeInfo(EmployeeInfo employeeInfo);

    void saveAndUpdate(EmployeeInfo employeeInfo);
}
