package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.EmployeeInfo;

public interface EmployeeInfoService {
    public void addEmployeeInfo(EmployeeInfo employeeInfo);

    public void saveAndUpdate(EmployeeInfo employeeInfo);
}
