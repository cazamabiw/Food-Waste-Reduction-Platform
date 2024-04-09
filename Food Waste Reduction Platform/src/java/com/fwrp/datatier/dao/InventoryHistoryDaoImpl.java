/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.datatier.dto.InventoryHistoryDetailDTO;
import com.fwrp.models.InventoryHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author beyul
 */
public class InventoryHistoryDaoImpl implements InventoryHistoryDao {
    private DataSource dataSource;

    public InventoryHistoryDaoImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public List<InventoryHistory> getByInventoryId(int inventoryId) {
        List<InventoryHistory> inventoryHistoryList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM inventory_history WHERE inventory_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, inventoryId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        inventoryHistoryList.add(mapResultSetToInventoryHistory(resultSet));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
        return inventoryHistoryList;
    }

    @Override
    public InventoryHistory get(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM inventory_history WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToInventoryHistory(resultSet);
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
    public List<InventoryHistory> getAll() {
        List<InventoryHistory> inventoryHistoryList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM inventory_history";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    inventoryHistoryList.add(mapResultSetToInventoryHistory(resultSet));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
        return inventoryHistoryList;
    }

    @Override
    public void insert(InventoryHistory inventoryHistory) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO inventory_history (inventory_id, recipient_id, quantity, action, date_modified) " +
                         "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, inventoryHistory.getInventoryId());
                statement.setInt(2, inventoryHistory.getRecipientId());
                statement.setInt(3, inventoryHistory.getQuantity());
                statement.setString(4, inventoryHistory.getAction());
                statement.setTimestamp(5, new Timestamp(inventoryHistory.getDateModified().getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void update(InventoryHistory inventoryHistory) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(InventoryHistory inventoryHistory) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private InventoryHistory mapResultSetToInventoryHistory(ResultSet resultSet) throws SQLException {
        InventoryHistory inventoryHistory = new InventoryHistory();
        inventoryHistory.setId(resultSet.getInt("id"));
        inventoryHistory.setInventoryId(resultSet.getInt("inventory_id"));
        inventoryHistory.setRecipientId(resultSet.getInt("recipient_id"));
        inventoryHistory.setQuantity(resultSet.getInt("quantity"));
        inventoryHistory.setAction(resultSet.getString("action"));
        inventoryHistory.setDateModified(resultSet.getTimestamp("date_modified"));
        return inventoryHistory;
    }

@Override
  public List<InventoryHistoryDetailDTO> getInventoryHistoryByDateRange(java.util.Date startDate, java.util.Date endDate) {{
    List<InventoryHistoryDetailDTO> inventoryHistoryList = new ArrayList<>();
    try (Connection connection = dataSource.getConnection()) {
        String sql = "SELECT ih.*, i.food_item_id, f.item_name, u.first_name " +
                     "FROM inventory_history ih " +
                     "JOIN inventory i ON ih.inventory_id = i.id " +
                     "JOIN users u ON ih.recipient_id = u.user_id " +
                     "JOIN food_items f ON i.food_item_id = f.food_item_id " +
                     "WHERE ih.date_modified BETWEEN ? AND ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setTimestamp(1, new Timestamp(startDate.getTime()));
            statement.setTimestamp(2, new Timestamp(endDate.getTime()));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    InventoryHistoryDetailDTO historyDetail = new InventoryHistoryDetailDTO();
                    historyDetail.setId(resultSet.getInt("id"));
                    historyDetail.setInventoryId(resultSet.getInt("inventory_id"));
                    historyDetail.setRecipientId(resultSet.getInt("recipient_id"));
                    historyDetail.setAction(resultSet.getString("action"));
                    historyDetail.setQuantity(resultSet.getInt("quantity"));
                    historyDetail.setDateModified(resultSet.getTimestamp("date_modified"));
                    historyDetail.setFoodItemId(resultSet.getInt("food_item_id"));
                    historyDetail.setFoodItemName(resultSet.getString("item_name"));
                    historyDetail.setActionBy(resultSet.getString("first_name"));
                    inventoryHistoryList.add(historyDetail);
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle exception appropriately
    }
    return inventoryHistoryList;
}
}
}
