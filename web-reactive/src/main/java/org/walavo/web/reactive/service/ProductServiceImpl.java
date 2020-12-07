package org.walavo.web.reactive.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.walavo.web.reactive.controller.dto.ProductDto;
import org.walavo.web.reactive.mappers.ApiMappers;
import org.walavo.web.reactive.message.MessagePublisher;
import org.walavo.web.reactive.model.entity.Product;
import org.walavo.web.reactive.model.repository.ProductRepository;
import org.walavo.web.reactive.thirdparty.ProductApi;
import org.walavo.web.reactive.util.ProductUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl {

    @Autowired
    private ProductApi productApi;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessagePublisher publisher;

    public Mono<ProductDto> saveAsync(ProductDto productDto) {

        return Mono.just(productDto)
                .map(product -> publisher.sendMessage(product))
                .doOnSubscribe(success -> log.info("Success save product"))
                .doOnError(exception -> log.error("Error occurred while consuming message", exception));
    }

    public Mono<ProductDto> save(ProductDto productDto) {

        return Mono.just(productDto)
                .map(ApiMappers.apiToEntity)
                .map(productEntity -> productRepository.save(productEntity))
                .map(ApiMappers.entityToApiProduct)
                .doOnSubscribe(success -> log.info("Success save product"))
                .doOnError(exception -> log.error("Error occurred while consuming message", exception));
    }

    public Mono<ProductDto> update(ProductDto productDto) {
        String skuCode = productDto.getSkuCode();
        return Mono.justOrEmpty(productRepository.findBySkuCode(skuCode))
                .switchIfEmpty(saveProductBySKu(skuCode))
                .map(productFound -> ProductUtil.foundProductUpdate(productDto, productFound))
                .map(productEntity -> productRepository.save(productEntity))
                .map(ApiMappers.entityToApiProduct)
                .doOnSubscribe(success -> log.info("Success update product"))
                .doOnError(exception -> log.error("Error occurred while consuming message", exception));
    }

    public Flux<ProductDto> findAll(List<String> skus) {
        return Flux.merge(getProductsApi(skus), getProductsEntity(skus))
                .subscribeOn(Schedulers.immediate())
                .doOnSubscribe(success -> log.info("Success findAll product"))
                .doOnError(exception -> log.error("Error occurred while consuming message", exception));
    }

    public Mono<Product> saveProductBySKu(String skuCode) {
        return productApi.callProductApiBySku(skuCode)
                .map(ApiMappers.apiProductToEntity)
                .map(productEntity -> productRepository.save(productEntity))
                .doOnSubscribe(success -> log.info("Success find All product"))
                .doOnError(exception -> log.error("Error occurred while consuming message", exception));
    }

    public Flux<ProductDto> getProductsEntity(List<String> skus) {
        return Flux.just(productRepository.findBySkuCodes(skus))
                .flatMap(Flux::fromIterable)
                .map(ApiMappers.entityToApiProduct)
                .doOnSubscribe(success -> log.info("Success find All product"))
                .doOnError(exception -> log.error("Error occurred while consuming message", exception));
    }

    public Flux<ProductDto> getProductsApi(List<String> skus) {
        return productApi.callProductApi(skus)
                .map(ApiMappers.mapperApiProduct)
                .doOnSubscribe(success -> log.info("Success Find All Api product"))
                .doOnError(exception -> log.error("Error occurred while consuming message", exception));
    }

}
