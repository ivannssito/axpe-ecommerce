package com.ivan.ecommerce.h2.repository;

import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.core.model.exception.FilterPricesException;
import com.ivan.ecommerce.core.model.filter.PricesFilter;
import com.ivan.ecommerce.core.repository.PricesRepository;
import com.ivan.ecommerce.h2.jparepository.PricesJpaRepository;
import com.ivan.ecommerce.h2.mapper.PriceH2Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PricesRepositoryImpl implements PricesRepository {

    private final PricesJpaRepository pricesJpaRepository;
    private final PriceH2Mapper mapper;

    @Override
    public Price filterPrices(PricesFilter filter) {
        try {
            var p = pricesJpaRepository.findSuitablePriceForFilter(filter);
            return mapper.entityToCore(p);
        } catch (Exception e) {
            throw new FilterPricesException(e);
        }
    }
}
