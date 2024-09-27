package com.example.carsFactory.factRepository;


import com.example.carsFactory.factInterface.RepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
public class FactoryRepository3 implements RepoInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<String> carslist() {
        String query = "Select * from luxuryItems";
        RowMapper<String> map = new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                String item = rs.getString("items") ;
                return item;
            }
        };
        List<String> items = jdbcTemplate.query(query,map);
        return items;
    }


    @Override
    public void addCars(StringBuilder sb, int amount) {
        String s= String.valueOf(sb);
        String query = "insert into luxuryItems value (?,?)";
        jdbcTemplate.update(query,s,amount);
    }

    @Override
    public void deleteCar(String deletableItem) {
        String query ="Delete from luxuryItems where items=?";
        jdbcTemplate.update(query,deletableItem);

    }

    @Override
    public void exchnageCar(String exItem, int avItemindex) {
        String query = "update luxuryItems set items = ? where items = ?";
        List<String> cars = carslist();
        String avCar= cars.get(avItemindex);
        jdbcTemplate.update(query,exItem,avCar);

    }

    @Override
    public List<Integer> carPrices() {
        String query = "Select * from luxuryItems";
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
