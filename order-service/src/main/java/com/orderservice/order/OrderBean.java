package com.orderservice.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@DynamicInsert
@DynamicUpdate
public class OrderBean {
    @Id
    private String orderId;
    private String orderUserId;
    private String orderRestaurantId;
    private String orderFoodId;
    private int status = 1;
    private Date createdOn = new Date();
}
