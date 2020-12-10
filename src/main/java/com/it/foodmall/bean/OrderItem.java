package com.it.foodmall.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class OrderItem {
    private String OID;
    private String FID;
    private String UID;
    private String count;
    private String money;
    private Date payTime;
    private String status;

    private Food food;
}
