package com.it.foodmall.service;

import com.it.foodmall.bean.Cart;
import com.it.foodmall.bean.Food;
import com.it.foodmall.bean.FoodAssociation;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.dao.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CartService {

    @Autowired
    CartDao cartDao;


    public List<FoodAssociation> addItem(String UID, Cart cart) {
        cart.setUID(UID);
        /**查询是否已经时存在，没有则添加，有则更新数量*/
        Cart cartDB = cartDao.queryItemByFIDAndUID(cart.getFID(), UID);
        if (cartDB != null) {
            cartDB.setCount(Integer.parseInt(cart.getCount()) + Integer.parseInt(cartDB.getCount()) + "");
            cartDB.setCost(Double.parseDouble(cart.getCost()) + Double.parseDouble(cartDB.getCost()) + "");
            cartDao.update(cartDB);
        } else {
            cartDao.addItem(cart);
        }
        return cartDao.queryFoodAssociation(cart.getFID());
    }

    public List<Cart> queryItem(String UID) {
        return cartDao.queryItem(UID);
    }


    public void deleteSelectedItem(List<Integer> cidList) {
        for (Integer CID : cidList){
            cartDao.deleteByCID(CID);
        }
    }
}
