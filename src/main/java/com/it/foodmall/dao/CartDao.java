package com.it.foodmall.dao;

import com.it.foodmall.bean.Cart;
import com.it.foodmall.bean.Food;
import com.it.foodmall.bean.FoodAssociation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartDao {
    int addItem(Cart cart);

    List<Cart> queryItem(String uid);

    Cart queryItemByFIDAndUID(@Param("FID") String fid, @Param("UID") String uid);

    void update(Cart cartDB);

    void deleteByCID(Integer cid);

    List<FoodAssociation> queryFoodAssociation(String fid);
}
