/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jessica Gunawan
 */
public class UserRoleDaoImpl implements UserRoleDao{
   private DataSource dataSource;

    public UserRoleDaoImpl() {
        this.dataSource = DataSource.getInstance();
    }
    @Override
    public UserRole get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UserRole> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(UserRole userRole) {

              // Implementation to insert retailer-specific data into the database
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userRole.getUserId());
                statement.setInt(2, userRole.getRoleId());
      
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void update(UserRole t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UserRole t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
    public UserRole getRoleByUserId(int userId) {
        String sql = "SELECT role_id FROM user_roles WHERE user_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int roleId = resultSet.getInt("role_id");
                    return new UserRole(userId, roleId); // Assuming UserRole has a constructor
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Return null if no role found for the user
    }
    
}
