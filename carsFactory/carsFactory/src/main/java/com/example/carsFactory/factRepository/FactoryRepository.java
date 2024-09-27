package com.example.carsFactory.factRepository;

import com.example.carsFactory.factInterface.RepoInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FactoryRepository implements RepoInterface {
    List<String> cars = new ArrayList<>(
            Arrays.asList("Mercedes", "ferari", "BMW"));
    List<Integer> prices = new ArrayList<>(
            Arrays.asList(1000000,2000000,3000000)
    );



    public List<String> carslist(){
        return cars;
    }


    public void addCars(StringBuilder sb,int amount) {
        cars.add(String.valueOf(sb));
        prices.add(amount);
    }

    public void deleteCar(String deletableCar) {
        cars.remove(deletableCar);
    }

    public void exchnageCar(String exCar, int avCarindex) {
        cars.set(avCarindex,exCar);
    }



    public List<Integer> carPrices(){
        return prices;
    }
}
