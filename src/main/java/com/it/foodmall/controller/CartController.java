package com.it.foodmall.controller;

import com.it.foodmall.bean.Cart;
import com.it.foodmall.bean.Food;
import com.it.foodmall.bean.FoodAssociation;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.service.CartService;
import com.it.foodmall.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;


    @PostMapping("/addItem")
    public JsonResult addItem(Cart cart){
        List<FoodAssociation> foodList = cartService.addItem(JWTUtil.getTokenUserId(), cart);
        return JsonResult.success("添加成功,与其相关的推荐菜品",foodList);
    }

    @GetMapping("/queryItem")
    public JsonResult<List<Cart>> queryItem(){
        List<Cart> cartList = cartService.queryItem(JWTUtil.getTokenUserId());
        if(cartList.size() == 0) {
            return JsonResult.success("购物车为空");
        }else {
           return JsonResult.success("成功查询购物车",cartList);
        }
    }

    @DeleteMapping("/deleteItem")
    public JsonResult deleteSelectedItem(@RequestBody List<Integer> CIDList){

        System.out.println(CIDList);

        cartService.deleteSelectedItem(CIDList);
        return JsonResult.success("删除指定购物项成功");
    }
}
