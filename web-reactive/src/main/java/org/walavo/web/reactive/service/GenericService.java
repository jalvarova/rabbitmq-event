package org.walavo.web.reactive.service;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GenericService<T> {

    <S extends T> Mono<S> save(S var1);

    <S extends T> Flux<S> saveAll(Iterable<S> var1);

    <S extends T> Flux<S> saveAll(Publisher<S> var1);

    Mono<T> findById(String var1);

    Mono<T> findById(Publisher<String> var1);

    Flux<T> findAll(List<String> skus);

    Flux<T> findAllById(Iterable<String> var1);

    Flux<T> findAllById(Publisher<String> var1);

    Mono<Void> delete(T var1);

    Mono<Void> deleteAll(Iterable<? extends T> var1);

    Mono<Void> deleteAll(Publisher<? extends T> var1);
}
