/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.User;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jessica Gunawan
 */
public class UserDaoImpl implements UserDao {

    private DataSource dataSource;

    public UserDaoImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        user = new User();
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setFirstName(resultSet.getString("first_name"));
                        user.setLastName(resultSet.getString("last_name"));
                        user.setEmail(resultSet.getString("email"));
                        user.setPassword(resultSet.getString("user_password"));
                        user.setAddressLine(resultSet.getString("address_line"));
                        user.setCity(resultSet.getString("city"));
                        user.setProvince(resultSet.getString("province"));
                         user.setPhoneNumber(resultSet.getString("phone_number"));
                        user.setPostalCode(resultSet.getString("postal_code"));
                        user.setIsNotified(resultSet.getBoolean("is_notified"));
                        user.setLastUpdated(resultSet.getDate("last_updated"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }

        return user;
    }

@Override
public User get(int id) {
    User user = null;
    String sql = "SELECT * FROM users WHERE user_id = ?";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                user = new User(); // Remove the redundant declaration
                user.setUserId(resultSet.getInt("user_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setAddressLine(resultSet.getString("address_line"));
                user.setCity(resultSet.getString("city"));
                user.setProvince(resultSet.getString("province"));
                user.setPostalCode(resultSet.getString("postal_code"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
    }
    return user;
}


    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(User user) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO users (first_name, last_name, email, user_password, address_line, city, province, postal_code,is_notified,last_updated) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setString(5, user.getAddressLine());
                statement.setString(6, user.getCity());
                statement.setString(7, user.getProvince());
                statement.setString(8, user.getPostalCode());
                statement.setBoolean(9, false); //always false
                Timestamp lastUpdatedTimestamp = new Timestamp(user.getLastUpdated().getTime());
                statement.setTimestamp(10, lastUpdatedTimestamp);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void update(User user) {
      try (Connection connection = dataSource.getConnection()) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, user_password = ?, address_line = ?, city = ?, province = ?, postal_code = ?, last_updated = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getAddressLine());
            statement.setString(6, user.getCity());
            statement.setString(7, user.getProvince());
            statement.setString(8, user.getPostalCode());
           // statement.setBoolean(9, user.isNotified()); //perform in notification setting
            Timestamp lastUpdatedTimestamp = new Timestamp(user.getLastUpdated().getTime());
            statement.setTimestamp(9, lastUpdatedTimestamp);
            statement.setInt(10, user.getUserId()); // Assuming userId is the primary key
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
    } 
    }
    @Override
    public void delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmailInUse(String email) {
        boolean emailInUse = false;

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT COUNT(*) AS count FROM users WHERE email = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt("count");
                        emailInUse = count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }

        return emailInUse;
    }
  
   @Override
public List<User> getUsersSubscribedToSurplusFoodAlerts() {
    List<User> subscribedUsers = new ArrayList<>();
    String sql = "SELECT * FROM users WHERE is_notified = ?";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setBoolean(1, true);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setAddressLine(resultSet.getString("address_line"));
                user.setCity(resultSet.getString("city"));
                          user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setProvince(resultSet.getString("province"));
                user.setPostalCode(resultSet.getString("postal_code"));
                     user.setIsNotified(resultSet.getBoolean("is_notified"));
                // Add the user to the list
                subscribedUsers.add(user);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
    }
    return subscribedUsers;
}

}
