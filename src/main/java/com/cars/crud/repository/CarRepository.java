package com.cars.crud.repository;

import com.cars.crud.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);
}
