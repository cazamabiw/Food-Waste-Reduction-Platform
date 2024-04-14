/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fwrp.datatier.dao;

import java.util.List;

import com.fwrp.models.UserNotificationSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserNotificationSettingDaolmpl  implements UserNotificationSettingDao{

    private DataSource dataSource;

    public UserNotificationSettingDaolmpl() {
        this.dataSource = DataSource.getInstance();
    }

@Override
public UserNotificationSetting get(int id) {
    try (Connection connection = dataSource.getConnection()) {
        String sql = "SELECT * FROM user_notfication_settings  WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UserNotificationSetting setting = new UserNotificationSetting();
                    setting.setUserId(resultSet.getInt("user_id"));
                    setting.setEmail(resultSet.getBoolean("is_email"));
                    setting.setPhone(resultSet.getBoolean("is_phone"));
                    // Set other properties as needed
                    return setting;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
    }
    return null; // Return null if no matching record found or error occurred
}
    @Override
    public List<UserNotificationSetting> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(UserNotificationSetting userNotificationSetting) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO user_notfication_settings (user_id, is_email, is_phone) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userNotificationSetting.getUserId()); 
                statement.setBoolean(2, userNotificationSetting.isEmail());
                statement.setBoolean(3, userNotificationSetting.isPhone());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void update(UserNotificationSetting userNotificationSetting) {
        try (Connection connection = dataSource.getConnection()) {
        String sql = "UPDATE user_notfication_settings SET is_email = ?, is_phone = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, userNotificationSetting.isEmail());
            statement.setBoolean(2, userNotificationSetting.isPhone());
            statement.setInt(3, userNotificationSetting.getUserId());
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
    }
        
    }

    @Override
    public void delete(UserNotificationSetting t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
