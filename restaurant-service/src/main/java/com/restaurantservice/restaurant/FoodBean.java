package com.restaurantservice.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodBean {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String quantity;
    private String restaurantId;
    private int status=1;
    private Date CreatedOn = new Date();
}
