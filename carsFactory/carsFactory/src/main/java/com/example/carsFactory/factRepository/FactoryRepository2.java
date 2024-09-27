package com.example.carsFactory.factRepository;

import com.example.carsFactory.factInterface.RepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FactoryRepository2 implements  RepoInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<String> carslist() {
        String query = "Select * from carfactory";
        RowMapper<String> map = new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    String car = rs.getString("cars") ;
                return car;
            }
        };
        List<String> cars = jdbcTemplate.query(query,map);
        return cars;
    }


    @Override
    public void addCars(StringBuilder sb, int amount) {
        String s= String.valueOf(sb);
        String query = "insert into carfactory value (?,?)";
        jdbcTemplate.update(query,s,amount);
    }

    @Override
    public void deleteCar(String deletableCar) {
        String query ="Delete from carfactory where cars=?";
        jdbcTemplate.update(query,deletableCar);

    }

    @Override
    public void exchnageCar(String exCar, int avCarindex) {
        String query = "update carfactory set cars = ? where cars = ?";
        List<String> cars = carslist();
        String avCar= cars.get(avCarindex);
        jdbcTemplate.update(query,exCar,avCar);

    }

    @Override
    public List<Integer> carPrices() {
        String query = "Select * from carfactory";
        RowMapper<Integer> map = new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                int price = rs.getInt("amount");
                return price;
            }
        };
        List<Integer> prices = jdbcTemplate.query(query,map);
        return prices;
    }
}
