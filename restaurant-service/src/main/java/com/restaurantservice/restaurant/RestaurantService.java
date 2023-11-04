package com.restaurantservice.restaurant;

import com.restaurantservice.feignservices.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class RestaurantService {

    @Autowired RestaurantDao restaurantDao;
    @Autowired FoodService foodService;
    @Autowired RestTemplate restTemplate;

    //Get All Restaurant Details
    public List<RestaurantBean> getAllRestaurant(){
        List<RestaurantBean> restaurantBeanList = restaurantDao.findAll();
        restaurantBeanList.forEach(x->{
            x.setFoodList(foodService.getFoodByRestaurantId(x.getRestaurantId()));
        });
        return restaurantBeanList;
    }

    //Create Restaurant Account
    public RestaurantBean createRestaurant(RestaurantBean restaurantBean) {
        restaurantBean.setRestaurantId(UUID.randomUUID().toString());
        return restaurantDao.save(restaurantBean);
    }

    //Get Single Restaurant Details
    public RestaurantBean getRestaurantById(String restaurantId) {
        RestaurantBean restaurantBean = restaurantDao.findByRestaurantId(restaurantId);
        restaurantBean.setFoodList(foodService.getFoodByRestaurantId(restaurantBean.getRestaurantId()));
        return restaurantBean;
    }

    public FoodBean createFoodForRestaurant(String restaurantId,FoodBean foodBean) {
        foodBean.setRestaurantId(restaurantId);
        return foodService.createFoodByRestaurantId(foodBean);
    }

    public List<FoodBean> getFoodList() {
        String url = "http://FOOD-SERVICE/food";
        AtomicReference<List<FoodBean>> foodList = new AtomicReference<>(Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url , FoodBean[].class))));
        return foodList.get();
    }
}
