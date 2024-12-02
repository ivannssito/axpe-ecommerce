package com.ivan.ecommerce.h2.jparepository;

import com.ivan.ecommerce.core.model.filter.PricesFilter;
import com.ivan.ecommerce.h2.entity.PriceH2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PricesJpaRepository extends JpaRepository<PriceH2Entity, Integer> {

    @Query(value = """
            SELECT e
                FROM PriceH2Entity e
                WHERE e.productId = :#{#f.productId} AND
                    e.startDate <= :#{#f.activationDate} AND
                    e.endDate >= :#{#f.activationDate} AND
                    e.brand.id = :#{#f.brandId}
                ORDER BY e.priority DESC
                LIMIT 1
            """)
    PriceH2Entity findSuitablePriceForFilter(@Param("f") PricesFilter filter);
}
