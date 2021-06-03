package com.sportCoach.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreviewDto {
    private CategoryDto category;
    private List<ProductDto> products;
}
