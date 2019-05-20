package com.aistrong.hnyc_codecenter.common.paramInit;

import com.aistrong.hnyc_codecenter.common.constant.WsParamConstant;
import com.aistrong.hnyc_codecenter.system.entity.SysParam;
import com.aistrong.hnyc_codecenter.system.service.SysParamService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WsParamInit implements InitializingBean {
    @Autowired
    private SysParamService sysParamService;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<SysParam> list = sysParamService.getAllSysParam();
        for (int i = 0; i < list.size(); ++i) {
            SysParam param = list.get(i);
            WsParamConstant.paramMap.put(param.getCode(), param.getValue());
        }
    }
}
