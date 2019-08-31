package com.wenrj.yc_codecenter.system.service.Impl;

import com.wenrj.yc_codecenter.system.dao.SysParamDao;
import com.wenrj.yc_codecenter.system.entity.SysParam;
import com.wenrj.yc_codecenter.system.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysParamImpl implements SysParamService {
    @Autowired
    private SysParamDao sysParamDao;

    @Override
    public List<SysParam> getAllSysParam() {
        return sysParamDao.getAllSysParam();
    }
}
