package com.it.foodmall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer CID;
    private String FID;
    private String UID;
    private String count;
    private String cost;
    private Food food;
}
