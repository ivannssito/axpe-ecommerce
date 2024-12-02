package com.ivan.ecommerce.core.model.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricesFilter {
    private LocalDateTime activationDate;
    private Integer productId;
    private Integer brandId;
}
