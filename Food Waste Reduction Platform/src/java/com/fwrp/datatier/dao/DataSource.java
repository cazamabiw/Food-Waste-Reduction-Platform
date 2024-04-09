/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static DataSource instance = null;
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/fwrp?useSSL=false&allowPublicKeyRetrieval=true";
    private String username = "root";
    private String password = "1234";
    private String driverString = "com.mysql.cj.jdbc.Driver";

  //  Private constructor to prevent instantiation from outside
    private DataSource() {
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName(driverString);
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                throw new SQLException("Failed to establish a database connection.", ex);
            }
        }
        return connection;
    }
}
