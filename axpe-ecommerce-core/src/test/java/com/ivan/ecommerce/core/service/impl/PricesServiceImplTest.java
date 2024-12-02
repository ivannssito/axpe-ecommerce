package com.ivan.ecommerce.core.service.impl;

import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.core.model.filter.PricesFilter;
import com.ivan.ecommerce.core.repository.PricesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PricesServiceImplTest {

    @InjectMocks
    private PricesServiceImpl service;

    @Mock
    private PricesRepository repository;

    @Test
    void givenAFilterWhenServiceReturnsValueThenAssertResultIsNotNull() {
        // given
        PricesFilter filter = new PricesFilter();

        // when
        doReturn(new Price()).when(repository).filterPrices(filter);

        // then
        Price result = service.filterPrices(filter);

        assertThat(result).isNotNull();
    }
}