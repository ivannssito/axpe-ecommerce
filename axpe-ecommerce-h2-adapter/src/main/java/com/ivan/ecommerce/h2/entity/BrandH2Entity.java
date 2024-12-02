package com.ivan.ecommerce.h2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TAB_BRAND")
@Getter
@Setter
public class BrandH2Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BRAND_GEN")
    @SequenceGenerator(name = "SEQ_BRAND_GEN", sequenceName = "SEQ_BRAND", allocationSize = 1)
    private Integer id;

    @Column
    private String name;
}
