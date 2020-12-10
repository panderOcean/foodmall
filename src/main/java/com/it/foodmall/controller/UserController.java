package com.it.foodmall.controller;

import com.auth0.jwt.JWT;
import com.it.foodmall.bean.User;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.service.UserService;
import com.it.foodmall.utils.FileUploadUtil;
import com.it.foodmall.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public JsonResult login(User user){
        return userService.login(user.getUsername(), user.getPassword());

    }

    @PostMapping("/register")
    public JsonResult register(User user){
       return userService.register(user);
    }

    @PutMapping("/charge")
    public JsonResult charge(String chargeMoney){
        return userService.charge(JWTUtil.getTokenUserId(),chargeMoney);
    }


    @GetMapping("/findAllUser")
    public JsonResult findAllUser(){
       try {
           List<User> userList =  userService.findAll();
           return JsonResult.success("成功查询所用用户",userList);
       }catch (Exception e){
           return JsonResult.error("5000","查询失败");
       }
    }

    @GetMapping("/deleteUserById")
    public JsonResult deleteUserById(String UID){
        userService.deleteUserById(UID);
        return JsonResult.success("成功删除用户");

    }



}
