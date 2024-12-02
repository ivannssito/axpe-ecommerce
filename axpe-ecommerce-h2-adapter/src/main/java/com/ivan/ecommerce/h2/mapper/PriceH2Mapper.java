package com.ivan.ecommerce.h2.mapper;

import com.ivan.ecommerce.core.model.entity.Price;
import com.ivan.ecommerce.h2.entity.PriceH2Entity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                BrandH2Mapper.class
        }
)
public interface PriceH2Mapper {

    Price entityToCore(PriceH2Entity source);
}
