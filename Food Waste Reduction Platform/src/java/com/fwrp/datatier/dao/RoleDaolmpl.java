/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jessica Gunawan
 */
public class RoleDaolmpl implements RoleDao{
    private DataSource dataSource;

    public RoleDaolmpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public Role get(int id) {
      String sql = "SELECT role_name FROM roles WHERE role_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String roleName = resultSet.getString("role_name");
                    return new Role(id, roleName); // Assuming Role has a constructor
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null;  
    }

    @Override
    public List<Role> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Role t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Role t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Role t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Role getRoleByName(String roleName) {
         try (Connection connection = dataSource.getConnection()) {
        String sql = "SELECT * FROM roles WHERE role_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roleName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Extract role information from the result set
                    int roleId = resultSet.getInt("role_id");
                    String userRoleName = resultSet.getString("role_name");
                    // Create and return a Role object
                    return new Role(roleId, userRoleName);
                } else {
                    // Role with the specified name not found
                    return null;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
        return null;
    }
    }
    
}
