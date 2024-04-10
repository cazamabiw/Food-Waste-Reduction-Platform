/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;


import com.fwrp.models.FoodItem;
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
public class FoodItemDaoImpl implements FoodItemDao {

   private DataSource dataSource;

    public FoodItemDaoImpl() {
        this.dataSource = DataSource.getInstance();
    }
    @Override
    public FoodItem get(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM food_items WHERE food_item_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        FoodItem foodItem = new FoodItem();
                        foodItem.setFoodItemId(resultSet.getInt("food_item_id"));
                        foodItem.setItemName(resultSet.getString("item_name"));
                        foodItem.setItemDescription(resultSet.getString("item_description"));
                        return foodItem;
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
    public List<FoodItem> getAll() {
        List<FoodItem> foodItems = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM food_items";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    FoodItem foodItem = new FoodItem();
                    foodItem.setFoodItemId(resultSet.getInt("food_item_id"));
                    foodItem.setItemName(resultSet.getString("item_name"));
                    foodItem.setItemDescription(resultSet.getString("item_description"));
                    foodItems.add(foodItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
        return foodItems;
    }


    @Override
    public void insert(FoodItem t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(FoodItem t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(FoodItem t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FoodItem getFoodItemByName(String foodItemName) {
         try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM food_items WHERE item_name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, foodItemName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        FoodItem foodItem = new FoodItem();
                        foodItem.setFoodItemId(resultSet.getInt("food_item_id"));
                        foodItem.setItemName(resultSet.getString("item_name"));
                        foodItem.setItemDescription(resultSet.getString("item_description"));
                        return foodItem;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
        return null;
    }
    
}
