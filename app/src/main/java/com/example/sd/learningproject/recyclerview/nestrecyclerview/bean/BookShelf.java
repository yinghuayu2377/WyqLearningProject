package com.example.sd.learningproject.recyclerview.nestrecyclerview.bean;

import java.util.List;

public class BookShelf {

    private String name;
    private List<String> books;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public List<String> getBooks() {
        return books;
    }
}
