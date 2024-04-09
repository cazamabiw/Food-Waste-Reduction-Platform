/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.Inventory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author beyul
 */
public class InventoryDaoImpl implements InventoryDao {
    private DataSource dataSource;

    public InventoryDaoImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public List<Inventory> getByUserId(int userId) {
        List<Inventory> inventories = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM inventory WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        inventories.add(mapResultSetToInventory(resultSet));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
        return inventories;
    }

    @Override
    public Inventory get(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM inventory WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToInventory(resultSet);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
        return null;
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> inventories = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM inventory";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    inventories.add(mapResultSetToInventory(resultSet));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
        return inventories;
    }

    @Override
    public void insert(Inventory inventory) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO inventory (user_id, food_item_id, expiration_date, quantity, price, " +
                         "food_status_id, discounted_price, is_surplus, last_updated) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, inventory.getUserId());
                statement.setInt(2, inventory.getFoodItemId());
                statement.setDate(3, new java.sql.Date(inventory.getExpirationDate().getTime()));
                statement.setInt(4, inventory.getQuantity());
                statement.setDouble(5, inventory.getPrice());
                statement.setInt(6, inventory.getFoodStatusId());
                statement.setDouble(7, inventory.getDiscountedPrice());
                statement.setBoolean(8, inventory.isSurplus());
                statement.setTimestamp(9, new Timestamp(inventory.getLastUpdated().getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void update(Inventory inventory) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE inventory SET user_id = ?, food_item_id = ?, expiration_date = ?, " +
                         "quantity = ?, price = ?, food_status_id = ?, discounted_price = ?, is_surplus = ?, " +
                         "last_updated = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, inventory.getUserId());
                statement.setInt(2, inventory.getFoodItemId());
                statement.setDate(3, new java.sql.Date(inventory.getExpirationDate().getTime()));
                statement.setInt(4, inventory.getQuantity());
                statement.setDouble(5, inventory.getPrice());
                statement.setInt(6, inventory.getFoodStatusId());
                statement.setDouble(7, inventory.getDiscountedPrice());
                statement.setBoolean(8, inventory.isSurplus());
                statement.setTimestamp(9, new Timestamp(inventory.getLastUpdated().getTime()));
                statement.setInt(10, inventory.getId());
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void delete(Inventory inventory) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM inventory WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, inventory.getId());
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
    }

    private Inventory mapResultSetToInventory(ResultSet resultSet) throws SQLException {
        Inventory inventory = new Inventory();
        inventory.setId(resultSet.getInt("id"));
        inventory.setUserId(resultSet.getInt("user_id"));
        inventory.setFoodItemId(resultSet.getInt("food_item_id"));
        inventory.setExpirationDate(resultSet.getDate("expiration_date"));
        inventory.setQuantity(resultSet.getInt("quantity"));
        inventory.setPrice(resultSet.getDouble("price"));
        inventory.setFoodStatusId(resultSet.getInt("food_status_id"));
        inventory.setDiscountedPrice(resultSet.getDouble("discounted_price"));
        inventory.setSurplus(resultSet.getBoolean("is_surplus"));
        inventory.setLastUpdated(resultSet.getTimestamp("last_updated"));
        return inventory;
    }

@Override
public List<Inventory> getIsSurplusData(int userId) {
    List<Inventory> surplusInventoryList = new ArrayList<>();
    try (Connection connection = dataSource.getConnection()) {
        String sql = "SELECT * FROM inventory WHERE user_id = ? AND is_surplus = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setBoolean(2, true);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    surplusInventoryList.add(mapResultSetToInventory(resultSet));
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle exception appropriately
    }
    return surplusInventoryList;
}

@Override
public List<Inventory> getIsSurplusDataInAWeek(int userId) {
    List<Inventory> surplusInventoryList = new ArrayList<>();
    try (Connection connection = dataSource.getConnection()) {
        String sql = "SELECT * FROM inventory WHERE user_id = ? AND is_surplus = ? AND expiration_date <= DATE_ADD(CURRENT_DATE(), INTERVAL 7 DAY)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setBoolean(2, true);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    surplusInventoryList.add(mapResultSetToInventory(resultSet));
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle exception appropriately
    }
    return surplusInventoryList;
}

    @Override
    public List<Inventory> getIsSurplusData() {
  List<Inventory> surplusInventoryList = new ArrayList<>();
    try (Connection connection = dataSource.getConnection()) {
        String sql = "SELECT * FROM inventory WHERE is_surplus = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {         
            statement.setBoolean(1, true);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    surplusInventoryList.add(mapResultSetToInventory(resultSet));
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle exception appropriately     
    }
         return surplusInventoryList;

    }


    @Override
    public void updateInventoryQuantity(int id, int quantityDecrease) {
         try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE inventory SET quantity = quantity - ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, quantityDecrease);
                statement.setInt(2, id);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
    }

}
