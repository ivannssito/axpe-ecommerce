package com.ivan.ecommerce.rest.mapper;

import com.ivan.ecommerce.contract.model.FilterPricesFilterParameterDTO;
import com.ivan.ecommerce.contract.model.PriceDTO;
import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.core.model.filter.PricesFilter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceRestMapper {

    PricesFilter filterRestToCore(FilterPricesFilterParameterDTO source);

    @Mapping(target = "brandId", source = "brand.id")
    PriceDTO priceCoreToRest(Price source);
}
