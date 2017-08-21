package cass.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

/**
 * This class represent the car object
 */
@Table("cars")
@Data
@RequiredArgsConstructor
public class Car implements Serializable{

    @PrimaryKey
    private UUID id;

    private String name;

    private String brand;

    private String model;

    private String color;

}
