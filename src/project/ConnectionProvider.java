package project;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    private static ConnectionProvider instance;
    private Connection connection;

    private ConnectionProvider() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lms", "root", "123456"
            );
        } catch (Exception e) {
            System.out.println("Database connection creation failed: " + e);
        }
    }

    public static synchronized ConnectionProvider getInstance() {
        if (instance == null) {
            instance = new ConnectionProvider();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

