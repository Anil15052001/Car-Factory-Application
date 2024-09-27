package com.example.carsFactory.factInterface;

import org.springframework.stereotype.Component;

import java.util.List;


public interface RepoInterface {

    public List<String> carslist();
    public void addCars(StringBuilder sb,int amount);
    public void deleteCar(String deletableCar);
    public void exchnageCar(String exCar, int avCarindex);
    public List<Integer> carPrices();

}
