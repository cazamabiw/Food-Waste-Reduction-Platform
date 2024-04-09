/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.Consumer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class ConsumerDaoImpl implements ConsumerDao {

    private DataSource dataSource;

    public ConsumerDaoImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public Consumer get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Consumer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Consumer consumer) {
        // Implementation to insert retailer-specific data into the database
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO consumers (user_id, shipping_address,payment_method) VALUES (?, ?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, consumer.getUserId());
                statement.setString(2, consumer.getShippingAddress());
                statement.setString(3, consumer.getPaymentMethod());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void update(Consumer consumer) {
        try (Connection connection = dataSource.getConnection()) {
        String sql = "UPDATE consumers SET shipping_address = ?, payment_method = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, consumer.getShippingAddress());
            statement.setString(2, consumer.getPaymentMethod());
            statement.setInt(3, consumer.getUserId());
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception appropriately
    }
    }
    @Override
    public void delete(Consumer t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Consumer getConsumerByUserId(int userId) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM consumers WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Retrieve consumer details from the result set and create a Consumer object
                        Consumer consumer = new Consumer();
                        consumer.setUserId(resultSet.getInt("user_id"));
                          consumer.setPaymentMethod(resultSet.getString("payment_method"));
                            consumer.setShippingAddress(resultSet.getString("shipping_address"));
                        // Set other properties as needed
                        return consumer;
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
