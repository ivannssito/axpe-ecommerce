package com.ivan.ecommerce.rest.controller;

import com.ivan.ecommerce.contract.api.PricesApi;
import com.ivan.ecommerce.contract.model.FilterPricesFilterParameterDTO;
import com.ivan.ecommerce.contract.model.PriceDTO;
import com.ivan.ecommerce.core.service.PricesService;
import com.ivan.ecommerce.rest.mapper.PriceRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PricesController implements PricesApi {

    private final PricesService pricesService;
    private final PriceRestMapper mapper;

    @Override
    public ResponseEntity<PriceDTO> filterPrices(FilterPricesFilterParameterDTO filter) {
        var f = mapper.filterRestToCore(filter);
        var p = pricesService.filterPrices(f);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.priceCoreToRest(p));
    }
}
