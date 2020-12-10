package com.it.foodmall.service;

import com.alibaba.fastjson.JSON;
import com.it.foodmall.bean.*;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.dao.CartDao;
import com.it.foodmall.dao.FoodDao;
import com.it.foodmall.dao.OrderDao;
import com.it.foodmall.dao.UserDao;
import com.it.foodmall.utils.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CartDao cartDao;

    @Autowired
    FoodDao foodDao;

    public JsonResult generateOrder(String UID, String totalCost, List<Cart> cartList) {
        /**用户余额减少*/
        User user = userDao.findUserByUID(UID);
        if(Double.parseDouble(user.getAccount()) < Double.parseDouble(totalCost)){
            return JsonResult.error("400","用户余额不足，请及时充值");
        }
        user.setAccount(Double.parseDouble(user.getAccount()) - Double.parseDouble(totalCost) + "");
        userDao.update(user);

        /**生成订单*/
        Order order = new Order();
        String orderId = OrderUtil.getOrderIdByUUID();
        order.setOID(orderId);
        order.setUID(UID);

        order.setCreateTime(new Date());
        order.setTotalCost(totalCost);
        orderDao.insertOrder(order);

        /**生成订单项,并删除所选的购物车项*/
        for(Cart cart : cartList){
            OrderItem orderItem = new OrderItem();
            orderItem.setOID(orderId).setFID(cart.getFID()).setUID(UID).setCount(cart.getCount()).setMoney(cart.getCost()).setPayTime(new Date()).setStatus("未上菜");
            orderDao.insertOrderItem(orderItem);
            Food food = foodDao.selectFoodByFID(cart.getFID());
            food.setPurchase(food.getPurchase()+Integer.parseInt(cart.getCount()));
            foodDao.update(food);
            cartDao.deleteByCID(cart.getCID());
        }
        return JsonResult.success("下单成功");
    }

    public Map queryOrderByAdmin() {
        List<Order> orderList = orderDao.queryOrderByAdmin();
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String money = orderDao.queryOrderMoneyByAdmin(format);
        Map map = new HashMap();
        map.put("orderList",orderList);
        map.put("money",money);
        return map;
    }

    public Map queryOrderByUser(String UID) {

        List<Order> orderList = orderDao.queryOrderByUser(UID);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String money = orderDao.queryOrderMoneyByUser(UID,format);
        Map map = new HashMap();
        map.put("orderList",orderList);
        map.put("money",money);
        return map;
    }

    public List<OrderItem> queryOrderByOID(String oid) {
        return orderDao.queryOrderByOID(oid);
    }

    public void changeOrderStatus(String oid, String fid, String status) {
        orderDao.update(oid,fid,status);
    }
}
