/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beulah Nwokotubo
 */
public class UserRoleDAOImpl {
    private DataSource dataSource;

    public UserRoleDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addUserRole(int userId, int roleId) {
        String query = "INSERT INTO user_role (user_id, role_id) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, roleId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    @Override
    public void removeUserRole(int userId, int roleId) {
        String query = "DELETE FROM user_role WHERE user_id = ? AND role_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, roleId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    @Override
    public List<UserRole> getUserRoles(int userId) {
        List<UserRole> userRoles = new ArrayList<>();
        String query = "SELECT role_id FROM user_role WHERE user_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int roleId = resultSet.getInt("role_id");
                    UserRole userRole = new UserRole(userId, roleId);
                    userRoles.add(userRole);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return userRoles;
    }
}
