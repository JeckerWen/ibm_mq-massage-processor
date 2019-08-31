package com.wenrj.yc_codecenter.task.service.impl;

import com.wenrj.yc_codecenter.task.dao.EmployeeInfoDao;
import com.wenrj.yc_codecenter.task.entity.EmployeeInfo;
import com.wenrj.yc_codecenter.task.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeInfoImpl implements EmployeeInfoService {
    @Autowired
    EmployeeInfoDao employeeInfoDao;

    @Override
    public void addEmployeeInfo(EmployeeInfo employeeInfo) {
        employeeInfoDao.addEmployeeInfo(employeeInfo);
    }

    @Override
    public void saveAndUpdate(EmployeeInfo employeeInfo) {
        List<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
        list = employeeInfoDao.getByPersoncode(employeeInfo.getPersoncode());
        if (list.size() > 0) {
            employeeInfoDao.updateEmployeeInfo(employeeInfo);
        } else {
            employeeInfoDao.addEmployeeInfo(employeeInfo);
        }
    }
}
