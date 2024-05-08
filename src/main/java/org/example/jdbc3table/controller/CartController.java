package org.example.jdbc3table.controller;

import org.example.jdbc3table.model.Cart;
import org.example.jdbc3table.model.DTO.CartDTO;
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
        String idP = req.getParameter("id");
        String action = req.getParameter("action");
        if (action==null){
            showAllCartDTO(req, resp);
        }
        else {
            switch (action){
                case "edit":
                    showFormEdit(req, resp);
                    break;
                default:
                    showAllCartDTO(req, resp);

            }
        }
        if (idP==null){
            showAllCartDTO(req, resp);
        }
        else {
            int id = Integer.parseInt(idP);
            Product product = productService.selectById(id);
            List<User> lists = userService.selectAll();
            req.setAttribute("product", product);
            req.setAttribute("users", lists);
            RequestDispatcher dispatcher = req.getRequestDispatcher("order.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt( req.getParameter("id"));
        CartDTO cartDTO = cartService.findByID(id);
        req.setAttribute("cart", cartDTO);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllCartDTO(HttpServletRequest req, HttpServletResponse resp) {
        List<CartDTO> cartDTOS = cartService.showAllCart();
        req.setAttribute("carts", cartDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            //       lay thong tin
//        id product
            int productId = Integer.parseInt(req.getParameter("id"));
//        id user
            int userId = Integer.parseInt(req.getParameter("userid"));
//        number
            int number = Integer.parseInt(req.getParameter("number"));
//        b1: ghi vao db
            Cart c = new Cart(productId, userId, number);
            try {
                cartService.insert(c);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            //        number
            int number = Integer.parseInt(req.getParameter("number"));
            int id = Integer.parseInt(req.getParameter("id"));
            Cart cart = new Cart();
            cart.setId(id);
            cart.setNumber(id);
            try {
                cartService.update(cart);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
