package com.sportCoach.service;

import com.sportCoach.model.entity.Orders;
import com.sportCoach.model.entity.Product;

import java.util.List;

public interface IOrderService {
    Orders createOrder();
    List<Product> getProduct();
}
