package com.wenrj.yc_codecenter.task.service.impl;

import com.wenrj.yc_codecenter.task.dao.DeptInfoDao;
import com.wenrj.yc_codecenter.task.entity.DeptInfo;
import com.wenrj.yc_codecenter.task.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptInfoImpl implements DeptInfoService {
    @Autowired
    DeptInfoDao deptInfoDao;

    @Override
    public void addDeptInfo(DeptInfo deptInfo) {
        deptInfoDao.addDeptInfo(deptInfo);
    }

    @Override
    public void saveAndUpdate(DeptInfo deptInfo) {
        List<DeptInfo> list = new ArrayList<DeptInfo>();
        list = deptInfoDao.getByDeptCode(deptInfo.getDept_code());
        if (list.size() > 0) {
            deptInfoDao.updateDeptInfo(deptInfo);
        } else {
            deptInfoDao.addDeptInfo(deptInfo);
        }
    }
}
