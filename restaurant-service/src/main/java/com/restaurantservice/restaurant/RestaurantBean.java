package com.restaurantservice.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "restaurant")
public class RestaurantBean {
    private String restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    @Transient
    private List<FoodBean> foodList = new ArrayList<>();
    private Integer status = 1;
    private Date createdOn = new Date();
}
