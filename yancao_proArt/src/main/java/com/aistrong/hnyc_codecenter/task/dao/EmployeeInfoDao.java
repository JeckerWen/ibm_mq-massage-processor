package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.EmployeeInfo;

import java.util.List;

public interface EmployeeInfoDao {
    public void addEmployeeInfo(EmployeeInfo employeeInfo);

    public List<EmployeeInfo> getByPersoncode(String personcode);

    public void updateEmployeeInfo(EmployeeInfo employeeInfo);

}
