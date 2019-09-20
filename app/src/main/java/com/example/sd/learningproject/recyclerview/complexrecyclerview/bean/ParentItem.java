package com.example.sd.learningproject.recyclerview.complexrecyclerview.bean;

public class ParentItem {

    private int type;  // 指定item的类型
    private CategoryItem categoryItem;  // 分类item
    private BookItem bookItem;  // 书item

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public CategoryItem getCategoryItem() {
        return categoryItem;
    }

    public void setCategoryItem(CategoryItem categoryItem) {
        this.categoryItem = categoryItem;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }
}
