package com.ivan.ecommerce.rest.controller;

import com.ivan.ecommerce.contract.model.FilterPricesFilterParameterDTO;
import com.ivan.ecommerce.contract.model.PriceDTO;
import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.core.service.PricesService;
import com.ivan.ecommerce.rest.mapper.PriceRestMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PricesControllerTest {

    @InjectMocks
    private PricesController controller;

    @Mock
    private PricesService service;

    @Spy
    private PriceRestMapper mapper = Mappers.getMapper(PriceRestMapper.class);

    @Test
    void givenAFilterWhenFilterPricesCalledThenAssertResultIsNotNullAndResponseIsOk() {
        // given
        FilterPricesFilterParameterDTO filter = new FilterPricesFilterParameterDTO();


        // when
        doReturn(new Price()).when(service).filterPrices(any());

        // then
        ResponseEntity<PriceDTO> response = controller.filterPrices(filter);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void givenAFilterWhenFilterPricesReturnsNullThenAssertResultIsNullAndResponseIsNotFound() {
        // given
        FilterPricesFilterParameterDTO filter = new FilterPricesFilterParameterDTO();


        // when
        doReturn(null).when(service).filterPrices(any());

        // then
        ResponseEntity<PriceDTO> response = controller.filterPrices(filter);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode().value()).isEqualTo(404);
        assertThat(response.getBody()).isNull();
    }
}