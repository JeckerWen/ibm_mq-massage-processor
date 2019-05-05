package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.EmployeeInfo;

public interface EmployeeInfoService {
    void addEmployeeInfo(EmployeeInfo employeeInfo);

    void saveAndUpdate(EmployeeInfo employeeInfo);
}
