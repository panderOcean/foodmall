package com.it.foodmall.service;

import com.it.foodmall.bean.Food;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.dao.FoodDao;
import com.it.foodmall.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FoodService {

    @Autowired
    FoodDao foodDao;

    public List<Food> queryFood() {
        return foodDao.queryFood();
    }

    public JsonResult uploadFood(Food food, MultipartFile file) {
        try {
            String path = FileUploadUtil.uploadPhoto(file);
            food.setPhoto(path);
            foodDao.addFood(food);

            return JsonResult.success("菜品上传成功", null);
        } catch (IOException e) {
            e.printStackTrace();
            return JsonResult.error("50051", "菜品上传失败");
        }
    }

    public List<Food> queryFoodByCategory(String category) {
        return foodDao.queryFoodByCategory(category);

    }

    public List<Food> queryFoodByName(String name) {
       return foodDao.queryFoodByName(name);
    }

    public List<Food> queryFoodDetailsById(String fid) {
        return foodDao.queryFoodDetailsById(fid);
    }
}
