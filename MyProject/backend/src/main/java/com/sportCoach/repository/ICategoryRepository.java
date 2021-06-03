package com.sportCoach.repository;

import com.sportCoach.model.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
 * @created 09/03/2021 - 16:28
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
public interface ICategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}
