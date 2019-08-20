package com.example.sd.learningproject.recyclerview.complexrecyclerview;

import com.example.sd.learningproject.listview.customlistview.Fruit;

public class ComplexItem {
    private int type;
    private Fruit fruit;
    private String category;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
