package kz.aitu.training.fastjava.repository;

import kz.aitu.training.fastjava.database.PostgreSQL;
import kz.aitu.training.fastjava.models.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private final PostgreSQL DB;

    public ItemRepository(PostgreSQL db) {
        DB = db;
    }

    public boolean createItem(Item item) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            String query = "insert into items(name, description, price) values (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setDouble(3, item.getPrice());

            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
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

    public List<Item> getItems() {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            String query = "select * from items order by id;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Item> itemList = new ArrayList<>();
            while (resultSet.next()) {
                Item item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price")
                );
                itemList.add(item);
            }
            return itemList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
