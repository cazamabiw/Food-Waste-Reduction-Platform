/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import java.util.List;

import com.fwrp.models.UserFoodPreference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserFoodPreferenceDaolmpl implements UserFoodPreferenceDao{

    private DataSource dataSource;

    public UserFoodPreferenceDaolmpl() {
        this.dataSource = DataSource.getInstance();
    }
    @Override
    public UserFoodPreference get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UserFoodPreference> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
    public void insert(UserFoodPreference userFoodPreference) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO user_food_preferences (user_id, food_item_id) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userFoodPreference.getUserId());
                statement.setInt(2, userFoodPreference.getFoodItemId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void update(UserFoodPreference userFoodPreference) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE user_food_preferences SET food_item_id = ? WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userFoodPreference.getFoodItemId());
                statement.setInt(2, userFoodPreference.getUserId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void delete(UserFoodPreference userFoodPreference) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM user_food_preferences WHERE user_id = ? AND food_item_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userFoodPreference.getUserId());
                statement.setInt(2, userFoodPreference.getFoodItemId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public List<UserFoodPreference> getByUserId(int userId) {
        List<UserFoodPreference> userFoodPreferences = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM user_food_preferences WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        UserFoodPreference userFoodPreference = new UserFoodPreference();
                        userFoodPreference.setUserId(resultSet.getInt("user_id"));
                        userFoodPreference.setFoodItemId(resultSet.getInt("food_item_id"));
                        userFoodPreferences.add(userFoodPreference);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFoodPreferences;
    }
    
}
