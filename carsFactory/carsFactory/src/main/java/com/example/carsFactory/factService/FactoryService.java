package com.example.carsFactory.factService;

import com.example.carsFactory.factInterface.RepoInterface;
import com.example.carsFactory.factRepository.FactoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryService {

    RepoInterface repoInterface;

    public FactoryService(RepoInterface repoInterface){
        this.repoInterface = repoInterface;

    }




    public List<Integer> showPrice(){
        List<Integer> prices = repoInterface.carPrices();
        return prices;
    }

    public List<String> showCars(){
        List<String> cars = repoInterface.carslist();
        return cars;
    }

    public void addCars(String newCar, int amount) {
        StringBuilder sb = new StringBuilder(newCar);
        sb.append("Black");
        repoInterface.addCars(sb,amount);
    }

    public String deleteCar(String deletableCar) {
        List<String> cars = repoInterface.carslist();
        for (String c : cars) {
            if (c.equals(deletableCar)) {
                repoInterface.deleteCar(deletableCar);
                return deletableCar+" deleted";
            }
        }
        return deletableCar + " Not Available";
    }

    public String exchangeCar(String exCar, String avCar) {
        List<String> cars = repoInterface.carslist();
        int i = 0;
        for(String s : cars){
            if(s.equals(avCar)){
                repoInterface.exchnageCar(exCar,i);
                return "Exchanged";
            }
            else{
                i++;
            }
        }
        return avCar + " Not Available";
    }

    public int avlcars() {
        List<String> cars = repoInterface.carslist();
        int count = cars.size();
        return count;
    }

    public String findPrice(String car){
        List<Integer> prices = repoInterface.carPrices();

        List<String> cars = repoInterface.carslist();
        int i=0;
        for(String s : cars) {
            if (s.equals(car)) {
                break;
            } else {
                i++;
            }
        }

        if ( i >= cars.size()){
            return car+" Not available";
        }
        String price = String.valueOf(prices.get(i));
        return price;
    }
}
