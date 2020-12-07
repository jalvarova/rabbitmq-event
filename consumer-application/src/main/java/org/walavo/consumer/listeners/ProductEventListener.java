package org.walavo.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.walavo.consumer.config.ProductChannel;
import org.walavo.consumer.mapper.ProductMapper;
import org.walavo.consumer.model.entities.ProductDocument;
import org.walavo.consumer.model.repositories.ProductRepository;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@Component
@EnableBinding(ProductChannel.class)
public class ProductEventListener {

    @Autowired
    private ProductRepository repository;

    @Transactional
    @StreamListener(ProductChannel.PRODUCT)
    public void eventProductSave(@Header(name = "x-death", required = false) Map<?, ?> death,
                                 ProductDto productDto) {
        log.info("Event Init");
        //validateAttempt(getCountAttempt(death));
        repository.findBySkuCode(productDto.getSkuCode())
                .switchIfEmpty(saveProductBySKu(productDto))
                .map(productEntity -> productEntity)
                .doOnSubscribe(success -> log.info("Success Event Consumer " + success))
                .doOnError(exception -> log.error("Error occurred while consuming message ", exception))
                .block();

        log.info("Finished Event");

    }

    private Mono<ProductDocument> saveProductBySKu(ProductDto dto) {

        return Mono.just(dto)
                .map(ProductMapper.eventToDocument)
                //.subscribeOn(Schedulers.boundedElastic())
                .doOnNext(s -> repository.save(s))
                .log("Success save product");
    }
}
