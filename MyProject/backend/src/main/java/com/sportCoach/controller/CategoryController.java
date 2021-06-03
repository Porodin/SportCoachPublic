package com.sportCoach.controller;

import com.sportCoach.dto.CategoryDto;
import com.sportCoach.dto.PreviewDto;
import com.sportCoach.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @created 09/03/2021 - 16:15
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */


@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
    @GetMapping("/preview")
    public ResponseEntity<?> getCategoriesPreview(){
        List<PreviewDto> dtos = categoryService.getCategoriesPreview();
        if (dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }
}

