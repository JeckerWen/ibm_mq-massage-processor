package com.aistrong.hnyc_codecenter.task.method;

import com.aistrong.hnyc_codecenter.common.constant.WsParamConstant;
import com.aistrong.hnyc_codecenter.common.paramProcessor.WsParamProcessor;
import com.aistrong.hnyc_codecenter.common.util.BeanUtil;
import com.aistrong.hnyc_codecenter.task.entity.*;
import com.aistrong.hnyc_codecenter.task.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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

    public static Map WsParamMap = new HashMap();

    public void initMap() {
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_EMPLOYEE), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_EMPLOYEE));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CORP), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CORP));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_DEPT), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_DEPT));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_REGIONALISM), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_REGIONALISM));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG_TRADEMARK), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG_TRADEMARK));
    }

    public boolean infoToDao(String ws_param, Map map) {
        initMap();
        ws_param = ws_param.trim();
        if (ws_param.equals(WsParamProcessor.getParam(WsParamConstant.T_B_C_CORP))) {
            CorpInfo corpInfo = new CorpInfo();
            try {
                BeanUtil.mapToBean(map, corpInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            corpInfoService.saveAndUpdate(corpInfo);
        } else if (ws_param.equals(WsParamProcessor.getParam(WsParamConstant.T_B_C_DEPT))) {
            DeptInfo deptInfo = new DeptInfo();
            try {
                BeanUtil.mapToBean(map, deptInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            deptInfoService.saveAndUpdate(deptInfo);
        } else if (ws_param.equals(WsParamProcessor.getParam(WsParamConstant.T_B_C_REGIONALISM))){
            RegionalismInfo regionalismInfo = new RegionalismInfo();
            try {
                BeanUtil.mapToBean(map, regionalismInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            regionalismInfoService.saveAndUpdate(regionalismInfo);
        } else if (ws_param.equals(WsParamProcessor.getParam(WsParamConstant.T_B_C_EMPLOYEE))) {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            try {
                BeanUtil.mapToBean(map, employeeInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            employeeInfoService.saveAndUpdate(employeeInfo);
        } else if (ws_param.equals(WsParamProcessor.getParam(WsParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO))) {
            ProvideBealerBaseInfo provideBealerBaseInfo = new ProvideBealerBaseInfo();
            try {
                BeanUtil.mapToBean(map, provideBealerBaseInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            provideBealerBaseInfoService.saveAndUpdate(provideBealerBaseInfo);
        } else if (ws_param.equals(WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG_TRADEMARK))) {
            TrademarkInfo trademarkInfo = new TrademarkInfo();
            try {
                BeanUtil.mapToBean(map, trademarkInfo);
            } catch (Exception e) {
                System.out.println("ws_param:" + map.get("ws_param") + " msg_id:" + map.get("msg_id") +
                        "mapToBean Error.");
                e.printStackTrace();
            }
            trademarkInfoService.saveAndUpdate(trademarkInfo);
        } else if (ws_param.equals(WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG))) {
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
