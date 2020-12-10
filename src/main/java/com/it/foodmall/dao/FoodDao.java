package com.it.foodmall.dao;

import com.it.foodmall.bean.Food;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FoodDao {

    List<Food> queryFood();


    int addFood(Food food);

    List<Food> queryFoodByCategory(String category);

    void update(Food food);

    Food selectFoodByFID(String fid);

    List<Food> queryFoodByName(String name);

    List<Food> queryFoodDetailsById(String fid);
}
