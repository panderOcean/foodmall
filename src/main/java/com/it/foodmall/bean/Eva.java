package com.it.foodmall.bean;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Eva {
    private String EID;
    private String FID;
    private String UID;
    private double grade;
    private String eva;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date evaluateTime;
    private Food food;
    private User user;
}
