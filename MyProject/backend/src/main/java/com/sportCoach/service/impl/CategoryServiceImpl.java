package com.sportCoach.service.impl;

import com.sportCoach.dto.CategoryDto;
import com.sportCoach.dto.PreviewDto;
import com.sportCoach.dto.ProductDto;
import com.sportCoach.model.entity.Category;
import com.sportCoach.repository.ICategoryRepository;
import com.sportCoach.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @created 09/03/2021 - 16:20
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(m -> new CategoryDto(m.getId(), m.getCategoryOfGoods())).collect(Collectors.toList());
    }

    @Override
    public List<PreviewDto> getCategoriesPreview() {
        List<PreviewDto> result = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            List<ProductDto> products = new ArrayList<>();
            category.getProducts().stream().forEach(product -> products.add(product.toResponse()));
            result.add(new PreviewDto(category.toResponse(), products));

        }
        return result;
    }
}
