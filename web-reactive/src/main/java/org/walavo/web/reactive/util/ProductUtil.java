package org.walavo.web.reactive.util;

import org.walavo.web.reactive.controller.dto.ProductDto;
import org.walavo.web.reactive.model.entity.Product;
import org.walavo.web.reactive.thirdparty.model.ProductModelApi;
import reactor.core.publisher.Flux;

import javax.swing.plaf.SliderUI;
import java.math.BigDecimal;

public final class ProductUtil {

    public static Product foundProductUpdate(ProductDto productDto, Product product) {
        product.setDescription(productDto.getDescription());
        product.setHeight(productDto.getHeight());
        product.setLength(productDto.getLength());
        product.setPrice(productDto.getPrice());
        product.setWeight(productDto.getWeight());
        product.setWidth(productDto.getWidth());
        return product;
    }

    public static Flux<ProductDto> zipProducts(ProductModelApi api, Product product) {

        ProductDto productDto = ProductDto
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

        ProductDto productEntity = new ProductDto();
        product.setProductCode(product.getProductCode());
        product.setSkuCode(product.getSkuCode());
        product.setDescription(product.getDescription());
        product.setProductType(product.getProductType());
        product.setPrice(product.getPrice());
        product.setWeight(product.getWeight());
        product.setWidth(product.getWidth());
        product.setLength(product.getLength());
        product.setHeight(product.getHeight());
        product.setUnitMeasurement(product.getUnitMeasurement());
        product.setHierarchyCode(product.getHierarchyCode());

        return Flux.just(productDto, productEntity);
    }
}
