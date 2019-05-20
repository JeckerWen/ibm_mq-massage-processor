package com.aistrong.hnyc_codecenter.task.method;

import com.aistrong.hnyc_codecenter.common.constant.WsParamConstant;
import com.aistrong.hnyc_codecenter.common.util.BeanUtil;
import com.aistrong.hnyc_codecenter.task.entity.*;
import com.aistrong.hnyc_codecenter.task.service.*;
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
     */
    public boolean infoToDao(String ws_param, Map map) {
        ws_param = ws_param.trim();
        if (ws_param.equals(WsParamConstant.paramMap.get(WsParamConstant.T_B_C_CORP))) {
            CorpInfo corpInfo = new CorpInfo();
            try {
                BeanUtil.mapToBean(map, corpInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            corpInfoService.saveAndUpdate(corpInfo);
        } else if (ws_param.equals(WsParamConstant.paramMap.get(WsParamConstant.T_B_C_DEPT))) {
            DeptInfo deptInfo = new DeptInfo();
            try {
                BeanUtil.mapToBean(map, deptInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            deptInfoService.saveAndUpdate(deptInfo);
        } else if (ws_param.equals(WsParamConstant.paramMap.get(WsParamConstant.T_B_C_REGIONALISM))){
            RegionalismInfo regionalismInfo = new RegionalismInfo();
            try {
                BeanUtil.mapToBean(map, regionalismInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            regionalismInfoService.saveAndUpdate(regionalismInfo);
        } else if (ws_param.equals(WsParamConstant.paramMap.get(WsParamConstant.T_B_C_EMPLOYEE))) {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            try {
                BeanUtil.mapToBean(map, employeeInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            employeeInfoService.saveAndUpdate(employeeInfo);
        } else if (ws_param.equals(WsParamConstant.paramMap.get(WsParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO))) {
            ProvideBealerBaseInfo provideBealerBaseInfo = new ProvideBealerBaseInfo();
            try {
                BeanUtil.mapToBean(map, provideBealerBaseInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            provideBealerBaseInfoService.saveAndUpdate(provideBealerBaseInfo);
        } else if (ws_param.equals(WsParamConstant.paramMap.get(WsParamConstant.T_B_C_CIG_TRADEMARK))) {
            TrademarkInfo trademarkInfo = new TrademarkInfo();
            try {
                BeanUtil.mapToBean(map, trademarkInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            trademarkInfoService.saveAndUpdate(trademarkInfo);
        } else if (ws_param.equals(WsParamConstant.paramMap.get(WsParamConstant.T_B_C_CIG))) {
            CigInfo cigInfo = new CigInfo();
            try {
                BeanUtil.mapToBean(map, cigInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            cigInfoService.saveAndUpdate(cigInfo);
        }
        else {
            System.out.println("没有匹配的ws_param, 请确认.");
            return false;
        }
        return true;
    }
}
