package com.sportCoach.service;

import com.sportCoach.dto.ProductDto;
import com.sportCoach.dto.ProductDtoApi;
import com.sportCoach.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> createProduct(ProductDto product);
    ProductDtoApi getAll();
}
