package com.foodservice.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FoodService {
    @Autowired FoodDao foodDao;

    public FoodBean createFoodForRestaurant(FoodBean foodBean) {
        foodBean.setFoodId(UUID.randomUUID().toString());
        return foodDao.save(foodBean);
    }
}
