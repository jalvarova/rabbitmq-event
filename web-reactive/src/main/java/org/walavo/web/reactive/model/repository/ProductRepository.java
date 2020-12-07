package org.walavo.web.reactive.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.walavo.web.reactive.model.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p where skuCode in :skuCode")
    List<Product> findBySkuCodes(List<String> skuCode);

    Product findBySkuCode(String skuCode);
}
