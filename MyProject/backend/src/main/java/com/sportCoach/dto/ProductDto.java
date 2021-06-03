package com.sportCoach.dto;

import com.sportCoach.model.entity.Characteristics;
import com.sportCoach.model.entity.Images;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private Long id;
    private String nameOfProduct;
    private Double prise;
    private String link;
    private Long feedBacksCount;
    private String description;
    private Boolean status;
    private String brand;
    private Long weight;
    private Long amount;
    private String subcategory;
}
