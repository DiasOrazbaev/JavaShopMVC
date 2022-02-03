package kz.aitu.training.fastjava.repository;

import kz.aitu.training.fastjava.database.PostgreSQL;
import kz.aitu.training.fastjava.models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final PostgreSQL DB;

    public CustomerRepository(PostgreSQL db) {
        DB = db;
    }

    public boolean createCustomer(Customer customer) {
        Connection connection = null;

        try {
            connection = DB.getConnection();
            String query = "insert into customer(firstName, lastName, balance, phone) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setDouble(3, customer.getBalance());
            preparedStatement.setString(4, customer.getPhone());

            preparedStatement.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<Customer> getAll() {
        Connection connection = null;

        try {
            connection = DB.getConnection();
            String query = "select * from customer order by id;";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            List<Customer> customers = new ArrayList<>();
            while(resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDouble("balance"),
                        resultSet.getString("phone")
                );

                customers.add(customer);
            }

            return customers;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateBalance(int id, double balance) {
        Connection connection = null;

        try {
            connection = DB.getConnection();
            String query = "update customer set balance = ? where id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setDouble(1, balance);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
