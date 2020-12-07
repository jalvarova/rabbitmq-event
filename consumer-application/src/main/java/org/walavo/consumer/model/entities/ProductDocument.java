package org.walavo.consumer.model.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(value="products")
public class ProductDocument {

    @Id
    private String id;

    private String productCode;
    private String skuCode;
    private String productType;
    private String description;
    private BigDecimal price;
    private BigDecimal weight;
    private BigDecimal width;
    private BigDecimal length;
    private BigDecimal height;
    private String unitMeasurement;
    private String hierarchyCode;

}
