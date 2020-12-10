package com.it.foodmall.dao;

import com.it.foodmall.bean.Charge;
import com.it.foodmall.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

     User findUserByNameAndPassword(@Param("username") String username , @Param("password") String password) ;

    void update(User userDb);

    int findUserBySingleName(String username);

    int register(User user);
//    @Select("select * from users")
    User findUserByUID(String UID);

    int ChargeMoney(Charge charge);

    List<User> queryAllUser();

    void deleteUserById(String uid);
}
