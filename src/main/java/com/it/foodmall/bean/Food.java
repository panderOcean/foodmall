package com.it.foodmall.bean;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Food {
    private String FID;
    private String foodName;
    private String price;
    private String category;
    private String photo;
    private Integer purchase;
    private Double grade;
    private Integer evaTimes;
}
