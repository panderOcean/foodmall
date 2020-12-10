package com.it.foodmall.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String UID;
    private String username;
    private String password;
    private String avatar;
    private String account;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date lastLogin;
    private String chargeMoney;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date chargeTime;

}
