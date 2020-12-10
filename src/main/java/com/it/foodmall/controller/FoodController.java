package com.it.foodmall.controller;


import com.it.foodmall.bean.Food;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/queryFood")
    public JsonResult<List<Food>> queryFood(){
        List<Food> foodList =  foodService.queryFood();
        return JsonResult.success("成功查询菜品",foodList);
    }

    @GetMapping("/queryFoodByCategory")
    public JsonResult<List<Food>> queryFoodByCategory(String category){
        List<Food> foodList = foodService.queryFoodByCategory(category);
        if(foodList.size() == 0){
           return JsonResult.error("400","查无此菜或正确输入类别名");
        }else {
            return JsonResult.success("成功按类别查询",foodList);
        }
    }


    @PostMapping("/uploadFood")
    public JsonResult uploadFood(Food food , MultipartFile file){
        return foodService.uploadFood(food,file);
    }

    @GetMapping("/queryFoodByName")
    public JsonResult<List<Food>> queryFoodByName(String foodName){
        List<Food> foodNameList = foodService.queryFoodByName(foodName);
        if(foodNameList.size() == 0){
            return JsonResult.error("400","目前还没有此类菜名，请正确输入菜名");
        }else {
            return JsonResult.success("成功查询",foodNameList);
        }
    }

    @GetMapping("/queryFoodDetailsById")
    public JsonResult<List<Food>> queryFoodDetailsById(String FID){
        List<Food> foodList = foodService.queryFoodDetailsById(FID);
        return JsonResult.success("成功按ID查询",foodList);
    }

}
