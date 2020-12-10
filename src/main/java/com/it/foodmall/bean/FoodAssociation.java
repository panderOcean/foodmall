package com.it.foodmall.bean;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FoodAssociation {
    private String F1_FID;
    private String F1_foodName;
    private String F2_FID;
    private String F2_foodName;
    private String F2_price;
    private String F2_category;
    private String F2_photo;
}
