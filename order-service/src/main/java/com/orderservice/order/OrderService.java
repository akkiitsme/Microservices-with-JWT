package com.orderservice.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public OrderBean createOrder(String userId , String restaurantId , String foodId) {
        log.info("Order is created !!");
        return orderDao.save(OrderBean.builder()
                .orderId(UUID.randomUUID().toString())
                .orderUserId(userId)
                .orderRestaurantId(restaurantId)
                .orderFoodId(foodId)
                .status(1)
                .createdOn(new Date()).build());
    }

    @Async("asyncTaskExecutor")
    public void one(String id) throws InterruptedException {
        Thread.sleep(2000L);
        log.info("One: " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void Two(String id) throws InterruptedException {
        Thread.sleep(2000L);
        log.info("Two: " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void Three(String id) throws InterruptedException {
        Thread.sleep(2000L);
        log.info("Three: " + Thread.currentThread().getName());
    }


}
