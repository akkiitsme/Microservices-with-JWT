package com.restaurantservice.feignservices;

import com.restaurantservice.restaurant.FoodBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "FOOD-SERVICE")
public interface FoodService {

    @GetMapping("/food/restaurant-food/{restaurantId}")
    List<FoodBean> getFoodByRestaurantId(@PathVariable String restaurantId);

    @PostMapping("/food/create-food")
    FoodBean createFoodByRestaurantId(@RequestBody FoodBean foodBean);
}
