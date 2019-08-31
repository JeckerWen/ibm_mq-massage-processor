package com.wenrj.yc_codecenter.common.constant;

import com.wenrj.yc_codecenter.system.entity.FeedbackStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: ws_param参数: 通过ws_param来确定xml数据信息类型
 * @Author: WenRj
 * @Date: 2019/4/13
 */
public class ParamConstant {

    public static Map<String, FeedbackStatus> feedBackStatusMap = new HashMap<>();

    /**
     * 标识信息Map
     */
    public static Map<String, String> paramMap = new HashMap<>();
    /**
     * 人员信息
     */
    public static final String T_B_C_EMPLOYEE = "T_B_C_EMPLOYEE";
    /**
     *  组织信息
     */
    public static final String T_B_C_CORP = "T_B_C_CORP";
    /**
     * 部门信息
     */
    public static final String T_B_C_DEPT = "T_B_C_DEPT";
    /**
     * 行政区划信息
     */
    public static final String T_B_C_REGIONALISM = "T_B_C_REGIONALISM";
    /**
     * 供应商信息
     */
    public static final String T_B_C_PROVIDE_DEALER_BASEINFO = "T_B_C_PROVIDE_DEALER_BASEINFO";
    /**
     * 卷烟品牌信息
     */
    public static final String T_B_C_CIG_TRADEMARK = "T_B_C_CIG_TRADEMARK";
    /**
     * 卷烟规格信息
     */
    public static final String T_B_C_CIG = "T_B_C_CIG";

}
