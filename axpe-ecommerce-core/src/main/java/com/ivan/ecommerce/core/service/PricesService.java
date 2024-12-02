package com.ivan.ecommerce.core.service;

import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.core.model.filter.PricesFilter;

public interface PricesService {
    Price filterPrices(PricesFilter filter);
}
