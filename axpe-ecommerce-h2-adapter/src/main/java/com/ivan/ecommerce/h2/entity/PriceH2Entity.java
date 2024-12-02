package com.ivan.ecommerce.h2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TAB_PRICES")
@Getter
@Setter
public class PriceH2Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRICES_GEN")
    @SequenceGenerator(name = "SEQ_PRICES_GEN", sequenceName = "SEQ_PRICES", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BRAND_ID")
    private BrandH2Entity brand;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private Integer priceList;

    @Column
    private Integer productId;

    @Column
    private Integer priority;

    @Column
    private Float price;

    @Column
    private String curr;
}
