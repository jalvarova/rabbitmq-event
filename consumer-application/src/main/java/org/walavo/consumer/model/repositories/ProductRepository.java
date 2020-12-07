package org.walavo.consumer.model.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.walavo.consumer.model.entities.ProductDocument;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<ProductDocument, String> {

    Mono<ProductDocument> findBySkuCode(String skuCode);

}
