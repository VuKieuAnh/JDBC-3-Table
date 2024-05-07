package org.example.jdbc3table.controller;

import org.example.jdbc3table.model.Product;
import org.example.jdbc3table.service.product.IProductService;
import org.example.jdbc3table.service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.selectAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("listproduct.jsp");
        req.setAttribute("products", products);
        dispatcher.forward(req, resp);
    }
}
