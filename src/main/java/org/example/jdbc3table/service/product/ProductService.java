package org.example.jdbc3table.service.product;

import org.example.jdbc3table.model.Product;
import org.example.jdbc3table.service.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private Connection c = ConnectionDB.getConnection();
    @Override
    public void insert(Product object) throws SQLException {

    }

    @Override
    public Product selectById(int id) {
        try {
            PreparedStatement preparedStatement = c.prepareStatement("select * from product where id=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int number = resultSet.getInt("number");
                Product p = new Product(id, name, number, description);
                return p;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement("select * from product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int number = resultSet.getInt("number");
                String description = resultSet.getString("description");
                Product product = new Product(id, name, number, description);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product user) throws SQLException {
        return false;
    }
}
