package org.example.jdbc3table.service.cart;

import org.example.jdbc3table.model.Cart;
import org.example.jdbc3table.model.DTO.CartDTO;
import org.example.jdbc3table.model.Product;
import org.example.jdbc3table.service.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<CartDTO> showAllCart() {
        List<CartDTO> cartDTOS = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select cart.id, u.name as user, p.name as productname, cart.number from cart join product_manager_c0124i1.product p on p.id = cart.id_product join product_manager_c0124i1.user u on u.id = cart.id_user;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String user = resultSet.getString("user");
                int number = resultSet.getInt("number");
                String productname = resultSet.getString("productname");
                CartDTO product = new CartDTO(id, user, productname, number);
                cartDTOS.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartDTOS;
    }
}
