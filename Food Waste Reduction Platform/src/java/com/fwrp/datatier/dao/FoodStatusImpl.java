/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.FoodStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cazam
 */
public class FoodStatusDaolmpl implements FoodStatusDao{

   private DataSource dataSource;

    public FoodStatusDaolmpl() {
        this.dataSource = DataSource.getInstance();
    }
    @Override
    public FoodStatus get(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM food_statuses WHERE food_status_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        FoodStatus foodStatus = new FoodStatus();
                        foodStatus.setFoodStatusId(resultSet.getInt("food_status_id"));
                        foodStatus.setFoodStatus(resultSet.getString("food_status"));
                        return foodStatus;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
        return null;
    }

    @Override
    public List<FoodStatus> getAll() {
        List<FoodStatus> foodStatuses = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM food_statuses";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    FoodStatus foodStatus = new FoodStatus();
                    foodStatus.setFoodStatusId(resultSet.getInt("food_status_id"));
                    foodStatus.setFoodStatus(resultSet.getString("food_status"));
                    foodStatuses.add(foodStatus);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
        return foodStatuses;
    }

    @Override
    public void insert(FoodStatus t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(FoodStatus t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(FoodStatus t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
