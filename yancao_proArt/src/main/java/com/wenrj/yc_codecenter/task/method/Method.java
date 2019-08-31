package com.wenrj.yc_codecenter.task.method;

import com.wenrj.yc_codecenter.common.constant.ParamConstant;
import com.wenrj.yc_codecenter.common.exception.BusinessException;
import com.wenrj.yc_codecenter.common.util.BeanUtil;
import com.wenrj.yc_codecenter.task.entity.*;
import com.wenrj.yc_codecenter.task.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @Desc: 信息存储相关方法
 * @Author: WenRj
 * @Date: 2019/4/13
 */
@Component
public class Method {
    @Autowired
    private EmployeeInfoService employeeInfoService;

    @Autowired
    private CorpInfoService corpInfoService;

    @Autowired
    private DeptInfoService deptInfoService;

    @Autowired
    private RegionalismInfoService regionalismInfoService;

    @Autowired
    private ProvideBealerBaseInfoService provideBealerBaseInfoService;

    @Autowired
    private TrademarkInfoService trademarkInfoService;

    @Autowired
    private CigInfoService cigInfoService;

    /**
     * @Desc: 根据ws_param将信息存储到指定的表， 若不存在该类型的ws_param，则返回一个null值
     * @Author: WenRj
     * @param: 1.ws_param: ws_param值; 2.map: 该数据信息
     * @return: 是否成功
     * @Date: 2019/4/13
     * @update:2019/8/30
     */
    public boolean infoToDao(String ws_param, Map map) {
        ws_param = ws_param.trim();
        if (ws_param.equals(ParamConstant.paramMap.get(ParamConstant.T_B_C_CORP))) {
            CorpInfo corpInfo = new CorpInfo();
            BeanUtil.mapToBean(map, corpInfo);
            corpInfoService.saveAndUpdate(corpInfo);
        } else if (ws_param.equals(ParamConstant.paramMap.get(ParamConstant.T_B_C_DEPT))) {
            DeptInfo deptInfo = new DeptInfo();
            BeanUtil.mapToBean(map, deptInfo);
            deptInfoService.saveAndUpdate(deptInfo);
        } else if (ws_param.equals(ParamConstant.paramMap.get(ParamConstant.T_B_C_REGIONALISM))){
            RegionalismInfo regionalismInfo = new RegionalismInfo();
            BeanUtil.mapToBean(map, regionalismInfo);
            regionalismInfoService.saveAndUpdate(regionalismInfo);
        } else if (ws_param.equals(ParamConstant.paramMap.get(ParamConstant.T_B_C_EMPLOYEE))) {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            BeanUtil.mapToBean(map, employeeInfo);
            employeeInfoService.saveAndUpdate(employeeInfo);
        } else if (ws_param.equals(ParamConstant.paramMap.get(ParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO))) {
            ProvideBealerBaseInfo provideBealerBaseInfo = new ProvideBealerBaseInfo();
            BeanUtil.mapToBean(map, provideBealerBaseInfo);
            provideBealerBaseInfoService.saveAndUpdate(provideBealerBaseInfo);
        } else if (ws_param.equals(ParamConstant.paramMap.get(ParamConstant.T_B_C_CIG_TRADEMARK))) {
            TrademarkInfo trademarkInfo = new TrademarkInfo();
            BeanUtil.mapToBean(map, trademarkInfo);
            trademarkInfoService.saveAndUpdate(trademarkInfo);
        } else if (ws_param.equals(ParamConstant.paramMap.get(ParamConstant.T_B_C_CIG))) {
            CigInfo cigInfo = new CigInfo();
            BeanUtil.mapToBean(map, cigInfo);
            cigInfoService.saveAndUpdate(cigInfo);
        }
        else {
            throw new BusinessException(ParamConstant.feedBackStatusMap.get("202"));
        }
        return true;
    }
}
