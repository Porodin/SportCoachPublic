package com.sportCoach.controller;

/*
 * @created 09/03/2021 - 17:27
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */

import com.sportCoach.dto.ProductDtoApi;
import com.sportCoach.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class ProductController {

    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping(path = "/products/suggestion")
    public ResponseEntity<ProductDtoApi> getSuggestion() {
        ProductDtoApi productDtoApi = iProductService.getAll();

        return new ResponseEntity<>(productDtoApi,HttpStatus.OK);
    }

//http://127.0.0.1:8080/api/products/suggestion

    @GetMapping(path = "/products")
    public ResponseEntity getProduct(@RequestParam(name = "subCat", required = false) String subCat,
                                     @RequestParam(name = "prices", required = false) String prices,
                                     @RequestParam(name = "text", required = false) String text,
                                     @RequestParam(name = "brands", required = false) String brands) {
        return null;
    }

    @PostMapping( path = "/feedbacks")
    public ResponseEntity feedback() {
        return null;
    }
}
