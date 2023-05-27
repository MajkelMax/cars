package com.cars.crud.service;

import com.cars.crud.entity.Car;
import com.cars.crud.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository CarRepository) {
        this.carRepository = CarRepository;
    }
    // post method
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
    // post method
    public List<Car> saveCars(List<Car> cars) {
        return carRepository.saveAll(cars);
    }
    // get method
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    // Optional<T> findById(ID id);
    public Car findById(int id) {

        Optional<Car> result = carRepository.findById(id);

        Car theCar = null;

        if (result.isPresent()){
            theCar = result.get();
        } else {
            throw new RuntimeException("Did not find car id -" + id);
        }

        return theCar;
    }
    // get method
    public List<Car> getCarByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
    // delete method
    public String deleteCarById(int id) {
        carRepository.deleteById(id);
        return "Car by ID: " + id + " is deleted";
    }
    // update method
    public Car updateCar(Car car) {
        Car existingCar = carRepository.findById(car.getId()).orElse(null);
        existingCar.setBrand(car.getBrand());
        existingCar.setGeneration(car.getGeneration());
        existingCar.setModel(car.getModel());
        existingCar.setFuelType(car.getFuelType());
        return carRepository.save(existingCar);
    }


}
