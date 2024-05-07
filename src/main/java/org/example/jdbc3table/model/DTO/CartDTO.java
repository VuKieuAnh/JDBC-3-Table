package org.example.jdbc3table.model.DTO;

public class CartDTO {
    private int id;
    private String user;
    private String productname;
    private int number;

    public CartDTO(int id, String user, String productname, int number) {
        this.id = id;
        this.user = user;
        this.productname = productname;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
