package com.sportCoach.dto;

import com.sportCoach.model.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoApi {
    private List<ProductDto> items;
    private Double prises;
}
