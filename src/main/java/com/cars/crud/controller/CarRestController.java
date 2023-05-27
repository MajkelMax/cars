package com.cars.crud.controller;

import com.cars.crud.entity.Car;
import com.cars.crud.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    private CarService carService;

    @Autowired
    public CarRestController (CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/car")
    public Car addCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PostMapping("/cars")
    public List<Car> addCars(@RequestBody List<Car> cars) {
        return carService.saveCars(cars);
    }

    @GetMapping("/car")
    public List<Car> findAllCars() {
        return carService.getCars();
    }

    @GetMapping("/car/{id}")
    public Car findCarById(@PathVariable int id) {
        return carService.findById(id);
    }

    @GetMapping("/car/brand/{brand}")
    public List<Car> findCarByBrand(@PathVariable String brand) {
        return carService.getCarByBrand(brand);
    }

    @PutMapping("/car")
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @DeleteMapping("/car/{id}")
    public String deleteCar(@PathVariable int id) {
        return carService.deleteCarById(id);
    }
}
