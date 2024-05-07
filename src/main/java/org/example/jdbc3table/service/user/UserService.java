package org.example.jdbc3table.service.user;

import org.example.jdbc3table.model.Product;
import org.example.jdbc3table.model.User;
import org.example.jdbc3table.service.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private Connection c = ConnectionDB.getConnection();
    @Override
    public void insert(User object) throws SQLException {

    }

    @Override
    public User selectById(int id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        List<User> us = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement("select * from user");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("name");
                User user = new User(id, name, address);
                us.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return us;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }
}
