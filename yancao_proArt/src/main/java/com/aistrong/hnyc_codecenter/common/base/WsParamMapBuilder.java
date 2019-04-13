package com.aistrong.hnyc_codecenter.common.base;

import com.aistrong.hnyc_codecenter.common.constant.WsParamConstant;
import com.aistrong.hnyc_codecenter.common.paramProcessor.WsParamProcessor;

import java.util.HashMap;
import java.util.Map;

public class WsParamMapBuilder {
    public static Map WsParamMap = new HashMap();

    public static void initMap() {
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_EMPLOYEE), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_EMPLOYEE));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CORP), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CORP));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_DEPT), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_DEPT));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_REGIONALISM), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_REGIONALISM));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG));
        WsParamMap.put((String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG_TRADEMARK), (String) WsParamProcessor.getParam(WsParamConstant.T_B_C_CIG_TRADEMARK));
    }
}
