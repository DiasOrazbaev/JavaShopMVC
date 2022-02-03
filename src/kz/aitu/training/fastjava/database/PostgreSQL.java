package kz.aitu.training.fastjava.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL {

    public Connection getConnection() {
        String URL = "jdbc:postgresql://localhost:5432/simplyshopdb";
        try {
            Class.forName("org.postgresql.Driver"); // check to exist!
            Connection connection = DriverManager.getConnection(URL, "postgres", "150903");
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver Manager not installed yet!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
