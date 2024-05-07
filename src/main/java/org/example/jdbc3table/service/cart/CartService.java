package org.example.jdbc3table.service.cart;

import org.example.jdbc3table.model.Cart;
import org.example.jdbc3table.service.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CartService implements ICartService {
    private Connection connection = ConnectionDB.getConnection();
    @Override
    public void insert(Cart object) throws SQLException {
//        dien du lieu vao bang cart
        PreparedStatement statement = connection.prepareStatement("insert into cart (id_user, id_product, number) VALUE (?, ?, ?);");
        statement.setInt(1, object.getUser().getId());
        statement.setInt(2, object.getProduct().getId());
        statement.setInt(3, object.getNumber());
        statement.executeUpdate();
//        tru du lieu o bang product
        PreparedStatement statement1 = connection.prepareStatement("update product set number = number-? where id=?;");
        statement1.setInt(1, object.getNumber());
        statement1.setInt(2, object.getProduct().getId());
        statement1.executeUpdate();
    }

    @Override
    public Cart selectById(int id) {
        return null;
    }

    @Override
    public List<Cart> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Cart user) throws SQLException {
        return false;
    }
}
