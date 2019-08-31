package com.wenrj.yc_codecenter.common.paramInit;

import com.wenrj.yc_codecenter.common.constant.ParamConstant;
import com.wenrj.yc_codecenter.system.entity.FeedbackStatus;
import com.wenrj.yc_codecenter.system.entity.SysParam;
import com.wenrj.yc_codecenter.system.service.FeedbackStatusService;
import com.wenrj.yc_codecenter.system.service.SysParamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParamInit implements InitializingBean {
    private static Logger logger = Logger.getLogger(ParamInit.class);

    @Autowired
    private SysParamService sysParamService;

    @Autowired
    private FeedbackStatusService feedbackStatusService;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("【*******************标识信息Map初始化开始***********************】");
        List<SysParam> sysParamList = sysParamService.getAllSysParam();
        for (int i = 0; i < sysParamList.size(); ++i) {
            SysParam param = sysParamList.get(i);
            ParamConstant.paramMap.put(param.getCode(), param.getValue());
        }
        logger.info("【*******************标识信息Map初始化完成***********************】");

        logger.info("【*******************反馈状态Map初始化开始***********************】");
        List<FeedbackStatus> feedbackStatusesList = feedbackStatusService.getAllFeedBackStatus();
        for (int i = 0; i < feedbackStatusesList.size(); i++) {
            FeedbackStatus feedbackStatus = feedbackStatusesList.get(i);
            ParamConstant.feedBackStatusMap.put(feedbackStatus.getStatusCode(), feedbackStatus);
        }
        logger.info("【*******************反馈状态Map初始化完成***********************】");
    }
}
