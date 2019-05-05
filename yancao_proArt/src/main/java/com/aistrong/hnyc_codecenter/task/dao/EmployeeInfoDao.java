package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.EmployeeInfo;

import java.util.List;

public interface EmployeeInfoDao {
    void addEmployeeInfo(EmployeeInfo employeeInfo);

    List<EmployeeInfo> getByPersoncode(String personcode);

    void updateEmployeeInfo(EmployeeInfo employeeInfo);

}
