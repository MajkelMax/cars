package com.cars.crud.service;

import com.cars.crud.entity.Car;
import com.cars.crud.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;
    // post method
    public Car saveCar(Car car) {
        return repository.save(car);
    }
    // post method
    public List<Car> saveCars(List<Car> cars) {
        return repository.saveAll(cars);
    }
    // get method
    public List<Car> getCars() {
        return repository.findAll();
    }
    // get method
    public Car getCarById(int id) {
        return repository.findById(id).orElse(null);
    }
    // get method
    public Car getCarByBrand(String brand) {
        return repository.findByBrand(brand);
    }
    // delete method
    public String deleteCarById(int id) {
        repository.deleteById(id);
        return "Car by ID: " + id + " is deleted";
    }
    // update method
    public Car updateCar(Car car) {
        Car existingCar = repository.findById(car.getId()).orElse(null);
        existingCar.setBrand(car.getBrand());
        existingCar.setGeneration(car.getGeneration());
        existingCar.setModel(car.getModel());
        existingCar.setFuel_type(car.getFuel_type());
        return repository.save(existingCar);
    }


}
