package com.foodservice.food;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FoodDao extends MongoRepository<FoodBean,String> {
    FoodBean findByFoodId(String foodId);
    List<FoodBean> findByRestaurantId(String restaurantId);
}
