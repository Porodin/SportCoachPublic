package com.sportCoach.service;

import com.sportCoach.dto.CategoryDto;
import com.sportCoach.dto.PreviewDto;

import java.util.List;

/*
 * @created 09/03/2021 - 16:18
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
public interface ICategoryService {
    List<CategoryDto> getAllCategories();
    List<PreviewDto> getCategoriesPreview();
}
