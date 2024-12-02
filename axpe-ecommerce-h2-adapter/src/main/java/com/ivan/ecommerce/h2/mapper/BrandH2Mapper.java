package com.ivan.ecommerce.h2.mapper;

import com.ivan.ecommerce.core.model.entity.Brand;
import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.h2.entity.BrandH2Entity;
import com.ivan.ecommerce.h2.entity.PriceH2Entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandH2Mapper {

    Brand entityToCore(BrandH2Entity source);
}
