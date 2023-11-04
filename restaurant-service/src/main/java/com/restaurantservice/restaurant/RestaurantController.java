package com.restaurantservice.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired RestaurantService restaurantService;

    @GetMapping("/welcome")
    public ResponseEntity<?> HelloRestaurant(){
        return new ResponseEntity<>("Welcome to Restaurant-Service", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllRestaurant(){
        return new ResponseEntity<List<RestaurantBean>>(restaurantService.getAllRestaurant(), HttpStatus.OK);
    }
    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurant(@PathVariable String restaurantId){
        return new ResponseEntity<>(restaurantService.getRestaurantById(restaurantId), HttpStatus.OK);
    }

    @PostMapping("/create-restaurant")
    public ResponseEntity<?> createRestaurant(@RequestBody RestaurantBean restaurantBean){
       restaurantBean =  restaurantService.createRestaurant(restaurantBean);
        return new ResponseEntity<>(restaurantBean,HttpStatus.OK);
    }

    @PostMapping("/create-restaurant-food/{restaurantId}")
    public ResponseEntity<?> createFoodForRestaurant(@PathVariable String restaurantId,@RequestBody FoodBean foodBean){
        restaurantService.createFoodForRestaurant(restaurantId,foodBean);
        return new ResponseEntity<>(restaurantService.getRestaurantById(restaurantId),HttpStatus.OK);
    }

    @GetMapping("/foodList")
    public ResponseEntity<?> getFoodList(){
        return new ResponseEntity<List<FoodBean>>(restaurantService.getFoodList(),HttpStatus.OK);
    }
}
