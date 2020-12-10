package com.it.foodmall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.it.foodmall.bean.Cart;
import com.it.foodmall.bean.Order;
import com.it.foodmall.bean.OrderItem;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.service.OrderService;
import com.it.foodmall.utils.JWTUtil;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/generateOrder")
    public JsonResult generateOrder(@RequestBody Map map){
        /**值得十分注意！*/
        String totalCost = (String) map.get("totalCost");
       String text =  JSONArray.toJSONString(map.get("cartList"));
        List<Cart> carts = JSONArray.parseArray(text, Cart.class);

        /**注意！从map接受过来的list集合不能直接用，得转成list才能用！*/
        return  orderService.generateOrder(JWTUtil.getTokenUserId(),totalCost,carts);
    }

    @GetMapping("/queryOrderByAdmin")
    public JsonResult<Map> queryAllOrderByAdmin(){
        Map map = orderService.queryOrderByAdmin();
        return JsonResult.success("成功查询所有订单",map);
    }
    @GetMapping("/queryOrderByUser")
    public JsonResult<Map> queryAllOrderByUser(){
        Map map = orderService.queryOrderByUser(JWTUtil.getTokenUserId());
        return JsonResult.success("成功查询所有订单",map);
    }

    @GetMapping("/queryOrderByOrderId")
    public JsonResult queryOrderItemByOrderId(String OID){
        System.out.println(OID);
        return JsonResult.success("成功查询订单项",orderService.queryOrderByOID(OID));

    }

    @PutMapping("/changeOrderStatus")
    public JsonResult changeOrderStatus(OrderItem orderItem){
        /**前端传OID,FID ,status*/
        orderService.changeOrderStatus(orderItem.getOID(),orderItem.getFID(),orderItem.getStatus());
        return JsonResult.success("修改状态成功");
    }

}
