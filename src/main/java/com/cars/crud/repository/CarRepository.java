package com.cars.crud.repository;

import com.cars.crud.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findByBrand(String brand);
}
