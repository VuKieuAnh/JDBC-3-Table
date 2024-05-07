package org.example.jdbc3table.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static final String URL = "jdbc:mysql://localhost:3306/product_manager_c0124i1";
    public static final String USER = "root";
    public static final String PASSWORD = "123456@Abc";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("ket noi khong thanh cong");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("ket noi ko thanh cong");
            throw new RuntimeException(e);
        }
        System.out.println("ket noi thanh cong");
        return connection;

    }
}
