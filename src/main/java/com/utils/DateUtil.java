package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public final static String Year_Month_Day_Hour_Minute_Second = "yyyy-MM-dd HH:mm:ss";

    public final static String Year_Month_Day_Hour_Minute_Second_with_Chinese = "yyyy年MM月dd日 HH时mm分ss秒";

    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(new Date());
    }

    public static String formatTime(String formatString) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);

        return sdf.format(new Date());
    }

}
