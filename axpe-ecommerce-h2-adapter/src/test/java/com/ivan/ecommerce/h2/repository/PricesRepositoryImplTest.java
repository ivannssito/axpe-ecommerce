package com.ivan.ecommerce.h2.repository;

import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.core.model.filter.PricesFilter;
import com.ivan.ecommerce.h2.entity.PriceH2Entity;
import com.ivan.ecommerce.h2.jparepository.PricesJpaRepository;
import com.ivan.ecommerce.h2.mapper.PriceH2Mapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PricesRepositoryImplTest {

    @InjectMocks
    private PricesRepositoryImpl repository;

    @Mock
    private PricesJpaRepository jpaRepository;

    @Mock
    private PriceH2Mapper mapper;

    @Test
    void givenAFilterWhenJpaRepositoryReturnsResultThenAssertResultIsNotNull() {
        // given
        PricesFilter filter = new PricesFilter();

        // when
        doReturn(new PriceH2Entity()).when(jpaRepository).findSuitablePriceForFilter(filter);
        doReturn(new Price()).when(mapper).entityToCore(any());

        // then
        Price result = repository.filterPrices(filter);

        assertThat(result).isNotNull();
    }
}