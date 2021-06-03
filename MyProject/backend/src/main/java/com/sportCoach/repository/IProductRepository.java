package com.sportCoach.repository;

import com.sportCoach.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
