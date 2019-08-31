package com.wenrj.yc_codecenter.common.util;

import com.wenrj.yc_codecenter.common.constant.ParamConstant;
import com.wenrj.yc_codecenter.common.exception.BusinessException;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static Logger logger = Logger.getLogger(DateUtil.class);

//    public static Date strToDate(String str) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = sdf.parse(str);
//        return sdf.parse(sdf.format(date));
//    }
    public static Timestamp strToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            logger.info("解析时间失败，请确认本消息的时间格式是否正确");
            e.printStackTrace();
            throw new BusinessException(ParamConstant.feedBackStatusMap.get("201"));
        }

        Timestamp times = new Timestamp(date.getTime());
        return times;
    }

    public static String dateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String currTime() throws ParseException{
        Date date = (Date) new Timestamp(new Date().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
