package com.restaurantservice.restaurant;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends MongoRepository<RestaurantBean,String> {

    RestaurantBean findByRestaurantId(String restaurantId);
}
