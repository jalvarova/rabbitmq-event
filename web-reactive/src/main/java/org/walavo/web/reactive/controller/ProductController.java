package org.walavo.web.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.walavo.web.reactive.controller.dto.ProductDto;
import org.walavo.web.reactive.service.ProductServiceImpl;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping(value = "/product/event", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createEvent(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.saveAsync(productDto));
    }

    @PostMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.save(productDto));
    }

    @PutMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.update(productDto));
    }


    @PostMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Flux<?>> findById(@RequestBody List<String> skus) {
        return ResponseEntity.ok(productService.findAll(skus));
    }
}
