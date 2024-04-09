/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.CharitableOrganization;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class CharitableOrganizationlmpl implements CharitableOrganizationDao{
    private DataSource dataSource;

    public CharitableOrganizationlmpl() {
        this.dataSource = DataSource.getInstance();
    }
    @Override
    public CharitableOrganization get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CharitableOrganization> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(CharitableOrganization charitableOrganization) {
        // Implementation to insert retailer-specific data into the database
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO charitable_organizations (user_id, organization_name) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, charitableOrganization.getUserId());
                statement.setString(2, charitableOrganization.getOrganizationName());


                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }    
    }

    @Override
    public void update(CharitableOrganization charitableOrganization) {
    try (Connection connection = dataSource.getConnection()) {
        String sql = "UPDATE charitable_organizations SET organization_name = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, charitableOrganization.getOrganizationName());
            statement.setInt(2, charitableOrganization.getUserId());
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
       }
    }
    @Override
    public void delete(CharitableOrganization t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CharitableOrganization getCharitableOrganizationByUserId(int userId) {
       
   try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM charitable_organizations WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Retrieve consumer details from the result set and create a Consumer object
                        CharitableOrganization charitableOrganization = new CharitableOrganization();
                        charitableOrganization.setUserId(resultSet.getInt("user_id"));
                         charitableOrganization.setOrganizationName(resultSet.getString("organization_name"));
                        // Set other properties as needed
                        return  charitableOrganization;
                    } else {
                        // Handle case where consumer is not found
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
            return null;
        }
        }
    
      
    
}
