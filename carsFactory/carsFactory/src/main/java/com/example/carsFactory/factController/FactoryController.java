package com.example.carsFactory.factController;


import com.example.carsFactory.factInterface.RepoInterface;
import com.example.carsFactory.factRepository.FactoryRepository;
import com.example.carsFactory.factRepository.FactoryRepository2;
import com.example.carsFactory.factService.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FactoryController  {

    @Autowired
    RepoInterface repoInterface;

    @Autowired
    FactoryService factoryService;

    @GetMapping("/getcars")
    @ResponseBody
    public List<String> getCars(){
        List<String> cars = factoryService.showCars();
        return cars;
    }

    @PostMapping("/addcar")
    @ResponseBody
    public String addcars(@RequestParam String name, @RequestParam int amount){
        factoryService.addCars(name,amount);
        return name+","+amount+" Added";
    }

    @DeleteMapping("/deletecar")
    @ResponseBody
    public String deleteCar(@RequestBody String name){
        String deleted = factoryService.deleteCar(name);
        return deleted;

    }

    @PutMapping("/exchangecar/{avCar}")
    @ResponseBody
    public String exchangeCar(@RequestBody String exCar,@PathVariable String avCar){
       String exchange = factoryService.exchangeCar(exCar,avCar);
       return exchange;
    }

    @GetMapping("/getprices")
    @ResponseBody
    public List<Integer> getprice(){
        List<Integer> prices = factoryService.showPrice();
        return prices;
    }

    @GetMapping("/carprice")
    @ResponseBody
    public String carprice(@RequestBody String car){
        String price = factoryService.findPrice(car);
        return price;
    }

    @GetMapping("/carcount")
    @ResponseBody
    public int  carcount(){
        int c_count = factoryService.avlcars();
        return c_count;
    }

}

