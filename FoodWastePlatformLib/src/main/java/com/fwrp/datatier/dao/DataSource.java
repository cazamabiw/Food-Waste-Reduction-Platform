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
 * @author cazam
 */
//singleton //associate with dao classes
public class DataSource {
    
    private static Connection connection = null;
    private String driverString = "com.mysql.cj.jdbc.Driver";
    private static DataSource instance;

    private DataSource() {
        try {
            String[] connectionInfo = openPropsFile();
            // Class.forName(this.driverString);
            connection = DriverManager.getConnection(connectionInfo[0], connectionInfo[1], connectionInfo[2]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the singleton instance of the DataSource class.
     * 
     * @return The singleton instance of the DataSource class.
     */
    public static DataSource Instance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private static String[] openPropsFile() {
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get("data/database.properties"))) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String connectionString = "jdbc:" + props.getProperty("db") + "://" + props.getProperty("host") + ":"
                + props.getProperty("port") + "/" + props.getProperty("name");
        String username = props.getProperty("user");
        String password = props.getProperty("pass");

        String[] info = new String[3];
        info[0] = connectionString;
        info[1] = username;
        info[2] = password;

        return info;
    }

    /**
     * Retrieves the database connection.
     * 
     * @return The database connection.
     */
    public Connection getConnection() {
        return connection;
    }
}
