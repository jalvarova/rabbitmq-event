package org.walavo.web.reactive.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column
    private String productCode;
    @Column
    private String skuCode;
    @Column
    private String productType;
    @Column
    private String description;
    @Column(precision = 11, scale = 3)
    private BigDecimal price;
    @Column(precision = 11, scale = 3)
    private BigDecimal weight;
    @Column(precision = 11, scale = 3)
    private BigDecimal width;
    @Column(precision = 11, scale = 3)
    private BigDecimal length;
    @Column(precision = 11, scale = 3)
    private BigDecimal height;
    @Column
    private String unitMeasurement;
    @Column
    private String hierarchyCode;

}
