package com.orderservice.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getOrdersList(){
        return new ResponseEntity<>(orderDao.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{userId}/{restaurantId}/{foodId}")
    public ResponseEntity<?> createOrder(@PathVariable String userId,@PathVariable String restaurantId,@PathVariable String foodId){
        return new ResponseEntity<>(orderService.createOrder(userId,restaurantId,foodId),HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<?> getHelloWorld(){
        Map<String,Object> map  = new HashMap<>();
        map.put("message","Hello World");
        map.put("dec","Zipkin server initialization");
        map.put("status",true);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @GetMapping("/async")
    public ResponseEntity<?> getAsynchronousData() throws InterruptedException, ExecutionException {
        orderService.one("1");
        orderService.Two("2");
        orderService.Three("3");
        return new ResponseEntity<>("" , HttpStatus.ACCEPTED);
    }





}
