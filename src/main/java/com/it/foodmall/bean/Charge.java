package com.it.foodmall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Charge {
    private int CID;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date chargeTime;
    private String chargeMoney;
    private String account;
    private String UID;
}
