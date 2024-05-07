package org.example.jdbc3table.model;

public class Cart {
    private int id;
    private Product product;
    private User user;
    private int number;

    public Cart() {
    }

    public Cart(Product product, User user, int number) {
        this.product = product;
        this.user = user;
        this.number = number;
    }

    public Cart(int id, Product product, User user, int number) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
