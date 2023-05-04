package com.cars.crud.controller;

import com.cars.crud.entity.Car;
import com.cars.crud.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping("/addcar")
    public Car addCar(@RequestBody Car car) {
        return service.saveCar(car);
    }

    @PostMapping("/addcars")
    public List<Car> addCars(@RequestBody List<Car> cars) {
        return service.saveCars(cars);
    }

    @GetMapping("/cars")
    public List<Car> findAllCars() {
        return service.getCars();
    }

    @GetMapping("/car/id/{id}")
    public Car findCarById(@PathVariable int id) {
        return service.getCarById(id);
    }

    @GetMapping("/car/brand/{brand}")
    public Car findCarByBrand(@PathVariable String brand) {
        return service.getCarByBrand(brand);
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car) {
        return service.updateCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        return service.deleteCarById(id);
    }
}
