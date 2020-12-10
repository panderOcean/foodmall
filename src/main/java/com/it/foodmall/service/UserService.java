package com.it.foodmall.service;

import com.it.foodmall.bean.Charge;
import com.it.foodmall.bean.User;
import com.it.foodmall.common.JsonResult;
import com.it.foodmall.dao.UserDao;
import com.it.foodmall.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.lang.model.element.NestingKind;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;
    public JsonResult login(String username, String password){
        User userDb = userDao.findUserByNameAndPassword(username, password);
        Map<String,String> map = new HashMap<>();
        if(userDb != null){
            String token = JWTUtil.getToken(userDb);
            userDb.setLastLogin(new Date());
            userDao.update(userDb);
            map.put("token",token);
            return JsonResult.success("登录成功",map);
        }else {
            return JsonResult.error("400","用户名或密码错误");
        }
    }

    public JsonResult register(User user) {
        Map<String, String> map = new HashMap<>();
        if(userDao.findUserBySingleName(user.getUsername()) == 1){
           return JsonResult.error("400","用户名已存在");
        }else {
            user.setCreateTime(new Date());
            user.setAccount(0.00 + "");
            userDao.register(user);
            return JsonResult.success("注册成功",null);
        }
    }

    public JsonResult charge(String UID,String chargeMoney) {

        User user = userDao.findUserByUID(UID);
        Charge charge = new Charge();
        charge.setUID(UID)
                .setChargeMoney(chargeMoney)
                .setChargeTime(new Date())
                .setAccount(Double.parseDouble(user.getAccount()) + Double.parseDouble(chargeMoney) + "");
        user.setAccount(Double.parseDouble(user.getAccount()) + Double.parseDouble(chargeMoney) + "");

        if(userDao.ChargeMoney(charge)==1){
            userDao.update(user);
            return JsonResult.success("充值成功");
        }else {
            return JsonResult.error("400","充值失败");
        }
    }

    public List<User> findAll() {

        return userDao.queryAllUser();

    }

    public void deleteUserById(String uid) {
        userDao.deleteUserById(uid);
    }


}
