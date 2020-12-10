package com.it.foodmall.dao;

import com.it.foodmall.bean.Order;
import com.it.foodmall.bean.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {

    void insertOrder(Order order);

    void insertOrderItem(OrderItem orderItem);

    List<Order> queryOrderByAdmin();

    List<Order> queryOrderByUser(String uid);

    String queryOrderMoneyByAdmin(String date);

    String queryOrderMoneyByUser(@Param("UID") String uid, @Param("dateTime") String format);


    List<OrderItem> queryOrderByOID(String oid);

    void update(@Param("OID") String oid, @Param("FID")  String fid, @Param("status") String status);
}
