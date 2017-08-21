package cass.repository;

import cass.domain.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Operations that return more than one instances return a flux in other case mono
 */
public interface CarRepository {

    Mono<Car> save(Car Car);
    Mono<Car> update(Car Car);
    Mono<Car> findOne(UUID CarId);
    Mono<Boolean> delete(UUID CarId);
    Flux<Car> findByColor(String color);
}
