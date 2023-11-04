package com.foodservice.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired FoodDao foodDao;
    @Autowired FoodService foodService;

    //Get All Food
    @GetMapping
    public ResponseEntity<?> getAllFood(){
        return new ResponseEntity<>(foodDao.findAll(), HttpStatus.OK);
    }

    //generate-Food
    @PostMapping("/create-food")
    public ResponseEntity<?> createFood(@RequestBody FoodBean foodBean){
        return new ResponseEntity<>(foodService.createFoodForRestaurant(foodBean),HttpStatus.OK);
    }

    //Get single food menu
    @GetMapping("/{foodId}")
    public ResponseEntity<?> getSingleFood(@PathVariable String foodId){
        return new ResponseEntity<>(foodDao.findByFoodId(foodId), HttpStatus.OK);
    }

    //Get Food List By RestaurantId
    @GetMapping("/restaurant-food/{restaurantId}")
    public ResponseEntity<?> getAllFoodForRestaurant(@PathVariable String restaurantId){
        return new ResponseEntity<>(foodDao.findByRestaurantId(restaurantId), HttpStatus.OK);
    }
}
