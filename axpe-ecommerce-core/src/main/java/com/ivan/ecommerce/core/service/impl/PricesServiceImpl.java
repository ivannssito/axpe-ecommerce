package com.ivan.ecommerce.core.service.impl;

import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.core.model.filter.PricesFilter;
import com.ivan.ecommerce.core.repository.PricesRepository;
import com.ivan.ecommerce.core.service.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    @Override
    public Price filterPrices(PricesFilter filter) {
        return pricesRepository.filterPrices(filter);
    }
}
