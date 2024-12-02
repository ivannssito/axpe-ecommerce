package com.ivan.ecommerce;

import com.ivan.ecommerce.contract.model.FilterPricesFilterParameterDTO;
import com.ivan.ecommerce.contract.model.PriceDTO;
import com.ivan.ecommerce.rest.controller.PricesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
class IntegrationTest {

    @Autowired
    private PricesController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void givenInputParamsCase1WhenFilterPricesThenAssertPriceIsExpectedAnsResultIsOK() {
        // given
        FilterPricesFilterParameterDTO filter = new FilterPricesFilterParameterDTO();
        filter.setActivationDate(LocalDateTime.parse("2020-06-14T10:00:00"));
        filter.setProductId(35455);
        filter.setBrandId(1);

        // when
        ResponseEntity<PriceDTO> response = controller.filterPrices(filter);

        // then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getPrice()).isEqualTo(35.50f);
    }

    @Test
    void givenInputParamsCase2WhenFilterPricesThenAssertPriceIsExpectedAnsResultIsOK() {
        // given
        FilterPricesFilterParameterDTO filter = new FilterPricesFilterParameterDTO();
        filter.setActivationDate(LocalDateTime.parse("2020-06-14T16:00:00"));
        filter.setProductId(35455);
        filter.setBrandId(1);

        // when
        ResponseEntity<PriceDTO> response = controller.filterPrices(filter);

        // then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getPrice()).isEqualTo(25.45f);
    }

    @Test
    void givenInputParamsCase3WhenFilterPricesThenAssertPriceIsExpectedAnsResultIsOK() {
        // given
        FilterPricesFilterParameterDTO filter = new FilterPricesFilterParameterDTO();
        filter.setActivationDate(LocalDateTime.parse("2020-06-14T21:00:00"));
        filter.setProductId(35455);
        filter.setBrandId(1);

        // when
        ResponseEntity<PriceDTO> response = controller.filterPrices(filter);

        // then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getPrice()).isEqualTo(35.50f);
    }

    @Test
    void givenInputParamsCase4WhenFilterPricesThenAssertPriceIsExpectedAnsResultIsOK() {
        // given
        FilterPricesFilterParameterDTO filter = new FilterPricesFilterParameterDTO();
        filter.setActivationDate(LocalDateTime.parse("2020-06-15T10:00:00"));
        filter.setProductId(35455);
        filter.setBrandId(1);

        // when
        ResponseEntity<PriceDTO> response = controller.filterPrices(filter);

        // then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getPrice()).isEqualTo(30.50f);
    }

    @Test
    void givenInputParamsCase5WhenFilterPricesThenAssertPriceIsExpectedAnsResultIsOK() {
        // given
        FilterPricesFilterParameterDTO filter = new FilterPricesFilterParameterDTO();
        filter.setActivationDate(LocalDateTime.parse("2020-06-16T21:00:00"));
        filter.setProductId(35455);
        filter.setBrandId(1);

        // when
        ResponseEntity<PriceDTO> response = controller.filterPrices(filter);

        // then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getPrice()).isEqualTo(38.95f);
    }
}