package com.it.foodmall.dao;

import com.it.foodmall.bean.Eva;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvaluationDao {
    List<Eva> queryEvaByAdmin();

    List<Eva> queryEvaByUser(String UID);

    void addEva(Eva eva);

    Double gradeAvg(String fid);
}
