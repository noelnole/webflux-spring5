package cass.web;

import cass.domain.Car;
import cass.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by nlre on 21/08/2017.
 */
@Component
public class CarHandler {

    private final CarService carService;

    @Autowired
    public CarHandler(CarService carService) {
        this.carService = carService;
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        UUID uuid = UUID.fromString(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return this.carService.findOne(uuid)
                .flatMap(car -> ServerResponse.ok().body(Mono.just(car), Car.class))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<Car> carToSave = serverRequest.bodyToMono(Car.class);
        return carToSave.flatMap(car ->
                ServerResponse.status(HttpStatus.CREATED).body(carService.save(car), Car.class)
        );
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        Mono<Car> carToBeUpdated = serverRequest.bodyToMono(Car.class);

        return carToBeUpdated.flatMap(car ->
                ServerResponse.status(HttpStatus.CREATED).body(carService.update(car), Car.class));
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        UUID uuid = UUID.fromString(serverRequest.pathVariable("id"));
        return this.carService.delete(uuid).flatMap(result -> ServerResponse.accepted().build());
    }
}
