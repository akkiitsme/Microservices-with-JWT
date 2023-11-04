package com.foodservice.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "food")
public class FoodBean {

    @Id
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String quantity;
    private String restaurantId;
    private int status=1;
    private Date CreatedOn = new Date();
}
