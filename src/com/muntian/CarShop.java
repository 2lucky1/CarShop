package com.muntian;

import com.muntian.car.Car;

import java.util.ArrayList;
import java.util.List;

public class CarShop {

    public static final String FILE_NAME = "data.txt";

    private List<Car> cars = new ArrayList<>();

    public void loadFromFile(){

    }

    public void addCar(Car car){
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
