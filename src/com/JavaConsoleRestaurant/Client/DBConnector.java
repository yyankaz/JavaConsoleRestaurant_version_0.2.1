package com.JavaConsoleRestaurant.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String URL = "jdbc:sqlite:data/client.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
