package org.example.jdbc3table.controller;

import org.example.jdbc3table.model.Cart;
import org.example.jdbc3table.model.Product;
import org.example.jdbc3table.model.User;
import org.example.jdbc3table.service.cart.CartService;
import org.example.jdbc3table.service.cart.ICartService;
import org.example.jdbc3table.service.product.IProductService;
import org.example.jdbc3table.service.product.ProductService;
import org.example.jdbc3table.service.user.IUserService;
import org.example.jdbc3table.service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "cartcontroller", urlPatterns = "/order")
public class CartController extends HttpServlet {
    private IProductService productService = new ProductService();
    private IUserService userService = new UserService();
    private ICartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.selectById(id);
        List<User> lists = userService.selectAll();
        req.setAttribute("product", product);
        req.setAttribute("users", lists);
        RequestDispatcher dispatcher = req.getRequestDispatcher("order.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       lay thong tin
//        id product
        int productId = Integer.parseInt(req.getParameter("id"));
//        id user
        int userId = Integer.parseInt(req.getParameter("userid"));
//        number
        int number = Integer.parseInt(req.getParameter("number"));
//        b1: ghi vao db
        User user = new User(userId);
        Product product = new Product(productId);
        Cart c = new Cart(product, user, number);
        try {
            cartService.insert(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
