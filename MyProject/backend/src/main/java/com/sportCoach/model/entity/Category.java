package com.sportCoach.model.entity;

import com.sportCoach.dto.CategoryDto;
import com.sportCoach.dto.ProductDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CATEGORY_OF_GOODS")
    private String categoryOfGoods;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();


    public void setCategoryOfGoods(String categoryOfGoods) {
        this.categoryOfGoods = categoryOfGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return id.equals(category.id) &&
                categoryOfGoods.equals(category.categoryOfGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryOfGoods);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryOfGoods() {
        return categoryOfGoods;
    }

    public CategoryDto toResponse(){
        return new CategoryDto(this.id,this.categoryOfGoods);
    }
}
