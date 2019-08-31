package com.wenrj.yc_codecenter.task.dao;

import com.wenrj.yc_codecenter.task.entity.EmployeeInfo;

import java.util.List;

public interface EmployeeInfoDao {
    void addEmployeeInfo(EmployeeInfo employeeInfo);

    List<EmployeeInfo> getByPersoncode(String personcode);

    void updateEmployeeInfo(EmployeeInfo employeeInfo);

}
