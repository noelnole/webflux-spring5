package cass.repository;

import cass.domain.Car;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


public class CarRepositoryImpl implements CarRepository{

    private final ReactiveCassandraOperations cassandraTemplate;

    public CarRepositoryImpl (ReactiveCassandraOperations cassandraTemplate){
        this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public Mono<Car> save(Car car) {
       return cassandraTemplate.insert(car);
    }

    @Override
    public Mono<Car> update(Car car) {
        return cassandraTemplate.update(car);
    }

    @Override
    public Mono<Car> findOne(UUID carId) {
        return cassandraTemplate.selectOneById(carId,Car.class);
    }

    @Override
    public Mono<Boolean> delete(UUID carId) {
        return cassandraTemplate.deleteById(carId,Car.class);
    }

    @Override
    public Flux<Car> findByColor(String color) {
        Select select = QueryBuilder.select().from("Cars");
        select.where(QueryBuilder.eq("color", color));
        return this.cassandraTemplate.select(select, Car.class);
    }
}
