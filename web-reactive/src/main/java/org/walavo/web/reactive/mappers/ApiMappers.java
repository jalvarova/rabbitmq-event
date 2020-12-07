package org.walavo.web.reactive.mappers;

import org.walavo.web.reactive.controller.dto.ProductDto;
import org.walavo.web.reactive.model.entity.Product;
import org.walavo.web.reactive.thirdparty.model.ProductModelApi;

import java.math.BigDecimal;
import java.util.function.Function;

@FunctionalInterface
public interface ApiMappers {

    void hello();

    Function<ProductModelApi, ProductDto> mapperApiProduct = (ProductModelApi api) -> ProductDto
            .builder()
            .productCode(api.getProductCode())
            .skuCode(api.getSkuCode())
            .description(api.getDescription())
            .productType(api.getProductType())
            .price(BigDecimal.valueOf(api.getPrice()))
            .weight(BigDecimal.valueOf(api.getWeight()))
            .width(BigDecimal.valueOf(api.getWidth()))
            .length(BigDecimal.valueOf(api.getLength()))
            .height(BigDecimal.valueOf(api.getHeight()))
            .unitMeasurement(api.getUnitMeasurement())
            .hierarchyCode(api.getHierarchyCode())
            .build();

    Function<ProductDto, Product> apiToEntity = (ProductDto api) -> {
        Product product = new Product();
        product.setProductCode(api.getProductCode());
        product.setSkuCode(api.getSkuCode());
        product.setDescription(api.getDescription());
        product.setProductType(api.getProductType());
        product.setPrice(api.getPrice());
        product.setWeight(api.getWeight());
        product.setWidth(api.getWidth());
        product.setLength(api.getLength());
        product.setHeight(api.getHeight());
        product.setUnitMeasurement(api.getUnitMeasurement());
        product.setHierarchyCode(api.getHierarchyCode());
        return product;
    };

    Function<ProductModelApi, Product> apiProductToEntity = (ProductModelApi api) -> {
        Product product = new Product();
        product.setProductCode(api.getProductCode());
        product.setSkuCode(api.getSkuCode());
        product.setDescription(api.getDescription());
        product.setProductType(api.getProductType());
        product.setPrice(BigDecimal.valueOf(api.getPrice()));
        product.setWeight(BigDecimal.valueOf(api.getWeight()));
        product.setWidth(BigDecimal.valueOf(api.getWidth()));
        product.setLength(BigDecimal.valueOf(api.getLength()));
        product.setHeight(BigDecimal.valueOf(api.getHeight()));
        product.setUnitMeasurement(api.getUnitMeasurement());
        product.setHierarchyCode(api.getHierarchyCode());
        return product;
    };
    Function<Product, ProductDto> entityToApiProduct = (Product api) -> ProductDto
            .builder()
            .productCode(api.getProductCode())
            .skuCode(api.getSkuCode())
            .description(api.getDescription())
            .productType(api.getProductType())
            .price(api.getPrice())
            .weight(api.getWeight())
            .width(api.getWidth())
            .length(api.getLength())
            .height(api.getHeight())
            .unitMeasurement(api.getUnitMeasurement())
            .hierarchyCode(api.getHierarchyCode())
            .build();
}
