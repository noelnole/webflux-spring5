package cass.service;

import cass.domain.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Car service  interface
 */
public interface CarService {

    Mono<Car> save(Car car);
    Mono<Car> update(Car car);
    Mono<Car> findOne(UUID uuid);
    Mono<Boolean> delete(UUID uuid);

    Flux<Car> findCarsByColor(String color);
}
