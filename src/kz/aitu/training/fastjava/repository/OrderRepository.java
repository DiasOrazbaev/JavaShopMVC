package kz.aitu.training.fastjava.repository;

import kz.aitu.training.fastjava.database.PostgreSQL;
import kz.aitu.training.fastjava.models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderRepository {
    private final PostgreSQL DB;

    public OrderRepository(PostgreSQL db) {
        DB = db;
    }

    public boolean createOrder(Order order) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            String query = "insert into orders(customerid, itemid, amount, totalprice) VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,order.getCustomerID());
            preparedStatement.setInt(2,order.getItemID());
            preparedStatement.setInt(3,order.getAmount());
            preparedStatement.setDouble(4,order.getTotalPrice());

            preparedStatement.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
