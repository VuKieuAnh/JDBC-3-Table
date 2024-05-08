package org.example.jdbc3table.model;

public class Cart {
    private int id;
    private int product_id;
    private int user_id;
    private int number;

    public Cart() {
    }

    public Cart(int id, int product_id, int user_id, int number) {
        this.id = id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.number = number;
    }

    public Cart(int product_id, int user_id, int number) {
        this.product_id = product_id;
        this.user_id = user_id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
