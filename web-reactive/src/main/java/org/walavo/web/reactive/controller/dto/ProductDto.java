package org.walavo.web.reactive.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
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
