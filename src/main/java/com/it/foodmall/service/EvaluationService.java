package com.it.foodmall.service;

import com.it.foodmall.bean.Eva;
import com.it.foodmall.bean.Food;
import com.it.foodmall.dao.EvaluationDao;
import com.it.foodmall.dao.FoodDao;
import com.it.foodmall.dao.OrderDao;
import com.it.foodmall.utils.JWTUtil;
import com.it.foodmall.utils.OrderUtil;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EvaluationService {

    @Autowired
    EvaluationDao evaluationDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    FoodDao foodDao;

    public List<Eva> queryEvaByAdmin() {
            return evaluationDao.queryEvaByAdmin();
    }


    public List<Eva> queryEvaByUser() {
        return evaluationDao.queryEvaByUser(JWTUtil.getTokenUserId());
    }

    public void addEva(String OID, Eva eva) {
        eva.setEvaluateTime(new Date()).setUID(JWTUtil.getTokenUserId()).setEID(OrderUtil.getOrderIdByUUID());
        //把评价加到评价表中
        evaluationDao.addEva(eva);
        //更新订单项的状态status
        orderDao.update(OID,eva.getFID(),"已评价");
        //更新Food食物表中的评价总分，评价人次
        Double grade = evaluationDao.gradeAvg(eva.getFID());
        Food food = foodDao.selectFoodByFID(eva.getFID());
        food.setEvaTimes(food.getEvaTimes() + 1).setGrade(grade);
        foodDao.update(food);
    }

}
