package com.pixel.service;

import com.pixel.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public  Order getOrder(String orderId) {
        return new Order(orderId, "Laptop", 1);
    }
}
