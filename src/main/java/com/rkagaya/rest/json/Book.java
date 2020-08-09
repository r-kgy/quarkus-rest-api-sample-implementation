package com.rkagaya.rest.json;

public class Book {

    public int id;
    public String name;
    public String description;

    public Book() {
    }

    public Book(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}