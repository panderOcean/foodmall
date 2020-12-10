package com.it.foodmall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OrderUtil {

    public static String getOrderIdByUUID() {
        String time = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int code = UUID.randomUUID().toString().hashCode();
        if (code < 0) {
            code = -code;
        }

        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return time + String.format("%04d", code);
    }

}
