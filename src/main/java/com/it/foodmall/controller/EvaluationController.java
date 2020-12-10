package com.it.foodmall.controller;

import com.it.foodmall.bean.Eva;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.service.EvaluationService;
import com.it.foodmall.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @GetMapping("/queryEvaByAdmin")
    public JsonResult<List<Eva>> queryAllEvaluationByAdmin(){
        return JsonResult.success("成功查询",evaluationService.queryEvaByAdmin());
    }

    @PostMapping("/queryEvaByUser")
    public JsonResult<List<Eva>> queryAllEvaluationByUser(){
        return JsonResult.success("成功查询",evaluationService.queryEvaByUser());
    }

    @PostMapping("/addEva")
    public JsonResult addEva(Eva eva,String OID){

        evaluationService.addEva(OID,eva);
        return JsonResult.success("成功添加");
    }
}
