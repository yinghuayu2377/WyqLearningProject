package com.example.sd.learningproject.recyclerview.complexrecyclerview.bean;

import com.example.sd.learningproject.recyclerview.complexrecyclerview.bean.Book;

import java.util.List;

public class Category {
    private String name;
    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
