package com.ivan.ecommerce.core.repository;

import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.core.model.filter.PricesFilter;

public interface PricesRepository {
    Price filterPrices(PricesFilter filter);
}
