package com.sportCoach.service.impl;


import com.sportCoach.dto.ProductDto;
import com.sportCoach.dto.ProductDtoApi;
import com.sportCoach.model.entity.Product;
import com.sportCoach.repository.IProductRepository;
import com.sportCoach.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    //Добавить товар в корзину
    @Override
    @Transactional
    public Optional<Product> createProduct(ProductDto product) {
        Optional<Product> currentProduct = this.repository.findById(product.getId());
        if (currentProduct.isPresent()) {

        }
        return currentProduct;
    }
    @Override
    @Transactional
    public ProductDtoApi getAll(){
        List<Product> productList = this.repository.findAll();
        ProductDtoApi dtoApi = new ProductDtoApi();


        List<ProductDto> list = productList.stream().map(m -> new ProductDto(
                m.getId(),
                m.getNameOfProduct(),
                m.getPrice(),
                m.getLink(),
                m.getFeedBacksCount(),
                m.getDescription(),
                m.getStatus(),
                m.getBrand(),
                m.getWeight(),
                m.getAmount(),
                m.getSubCategory()
                )).collect(Collectors.toList());

        Double prices = productList.stream().mapToDouble(Product::getPrice).sum();
        dtoApi.setItems(list);
        dtoApi.setPrises(prices);
        return dtoApi;

    }

}
