package org.example.jdbc3table.model;

public class Product {
    private int id;
    private String name;
    private int number;
    private String description;

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(String name, int number, String description) {
        this.name = name;
        this.number = number;
        this.description = description;
    }

    public Product(int id, String name, int number, String description) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
