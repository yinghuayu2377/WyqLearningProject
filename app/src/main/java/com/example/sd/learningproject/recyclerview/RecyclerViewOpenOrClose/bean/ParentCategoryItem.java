package com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.bean;

import java.util.List;

public class ParentCategoryItem {
    private int index;
    private boolean isShow;  // 展开状态
    private String categoryName;
    private List<ChildBookItem> childBookItems;  // 子item列表

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ChildBookItem> getChildBookItems() {
        return childBookItems;
    }

    public void setChildBookItems(List<ChildBookItem> childBookItems) {
        this.childBookItems = childBookItems;
    }
}
