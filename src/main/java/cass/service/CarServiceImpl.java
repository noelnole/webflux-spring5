package cass.service;

import cass.domain.Car;
import cass.repository.CarRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by nlre on 07/08/2017.
 */
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public Mono<Car> save(Car car) {
       return carRepository.save(car);
    }

    @Override
    public Mono<Car> update(Car car) {
        return carRepository.update(car);
    }

    @Override
    public Mono<Car> findOne(UUID uuid) {
        return carRepository.findOne(uuid);
    }

    @Override
    public Mono<Boolean> delete(UUID uuid) {
        return carRepository.delete(uuid);
    }

    @Override
    public Flux<Car> findCarsByColor(String color) {
        return carRepository.findByColor(color);
    }
}
