package com.JavaConsoleRestaurant.Client;

import java.sql.*;
import java.time.LocalDate;

import static com.JavaConsoleRestaurant.Client.DBConnector.connect;

public class ClientDAO {
    public void createTableIfNotExists() {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            String sqlCreate = "CREATE TABLE IF NOT EXISTS client (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "customerID TEXT," +
                    "firstName TEXT," +
                    "lastName TEXT," +
                    "dateOfBirth TEXT," +
                    "phone TEXT," +
                    "status TEXT DEFAULT 'basic', " +
                    "totalSpent REAL DEFAULT 0.0)";
            stmt.execute(sqlCreate);

            String sqlIndex = "CREATE UNIQUE INDEX IF NOT EXISTS idx_client_id ON client(customerID)";
            stmt.execute(sqlIndex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client) {
        String sql = "INSERT INTO client (customerID, firstName, lastName, dateOfBirth, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getID());
            pstmt.setString(2, client.getFirstName());
            pstmt.setString(3, client.getLastName());
            pstmt.setString(4, client.getDateOfBirth() != null ? client.getDateOfBirth().toString() : null);
            pstmt.setString(5, client.getContactPhoneNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client findClientByID(String id) {
        String sql = "SELECT * FROM client WHERE customerID = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String clientID = rs.getString("customerID");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String dobString = rs.getString("dateOfBirth");
                    LocalDate dateOfBirth = (dobString != null && !dobString.isEmpty()) ? LocalDate.parse(dobString) : null;
                    String phone = rs.getString("phone");
                    Status status = Status.valueOf(rs.getString("status"));

                    return new Client(clientID, firstName, lastName, dateOfBirth, phone);
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateTotalSpent(String clientId, double amount) {
        String sql = "UPDATE client SET totalSpent = totalSpent + ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, clientId);
            pstmt.executeUpdate();

            // После обновления проверим статус
            updateClientStatus(clientId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateClientStatus(String clientId) {
        String selectSql = "SELECT totalSpent FROM client WHERE id = ?";
        String updateSql = "UPDATE client SET status = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
            selectStmt.setString(1, clientId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                double total = rs.getDouble("totalSpent");
                String newStatus = switch (getStatus(total)) {
                    case 1 -> "regular";
                    case 2 -> "loyal";
                    case 3 -> "VIP";
                    default -> "regular";
                };

                updateStmt.setString(1, newStatus);
                updateStmt.setString(2, clientId);
                updateStmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getStatus(double totalSpent) {
        if (totalSpent >= 1000) {
            return 3; // VIP
        } else if (totalSpent >= 500) {
            return 2; // loyal
        } else {
            return 1; // regular
        }
    }
}
