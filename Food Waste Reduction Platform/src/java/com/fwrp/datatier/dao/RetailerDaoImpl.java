/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.datatier.dao.DataSource;
import com.fwrp.models.Retailer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class RetailerDaoImpl  implements RetailerDao{
  private DataSource dataSource;

    public RetailerDaoImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public Retailer get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Retailer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

public void insert(Retailer retailer) {
        // Implementation to insert retailer-specific data into the database
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO retailers (user_id, store_name, contact_person) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, retailer.getUserId()); // Assuming you have a userId field in Retailer
                statement.setString(2, retailer.getStoreName());
                statement.setString(3, retailer.getContactPerson());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }
    @Override
    public void update(Retailer retailer) {
        try (Connection connection = dataSource.getConnection()) {
        String sql = "UPDATE retailers SET store_name = ?, contact_person = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, retailer.getStoreName());
            statement.setString(2, retailer.getContactPerson());
            statement.setInt(3, retailer.getUserId());
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
        }
    }
    @Override
    public void delete(Retailer t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retailer getRetailerByUserId(int userId) {
    try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM consumers WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Retrieve consumer details from the result set and create a Consumer object
                        Retailer retailer = new Retailer();
                        retailer.setUserId(resultSet.getInt("user_id"));
                          retailer.setContactPerson(resultSet.getString("contact_person"));
                            retailer.setStoreName(resultSet.getString("store_name"));
                        // Set other properties as needed
                        return retailer;
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
