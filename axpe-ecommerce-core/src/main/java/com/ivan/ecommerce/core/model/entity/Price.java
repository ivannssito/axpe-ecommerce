package com.ivan.ecommerce.core.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Float price;
    private Brand brand;
}
