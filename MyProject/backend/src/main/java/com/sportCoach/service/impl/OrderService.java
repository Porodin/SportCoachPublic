package com.sportCoach.service.impl;

import com.sportCoach.model.entity.Orders;
import com.sportCoach.model.entity.Product;
import com.sportCoach.service.IOrderService;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderService implements IOrderService {
    private EntityManager entityManager;

    @Transactional
    public Orders createOrder() {
        Orders orders = new Orders();
        entityManager.persist(orders);

        return orders;
    }

    @Override
    //Возвращает список всех вещей, исеющихся в базе
    public List<Product> getProduct() {
        //Типизированный запрос, который будет возвращать Product
        TypedQuery<Product> query = entityManager.createQuery("select c from Product c", Product.class);
        return null;
    }
}

