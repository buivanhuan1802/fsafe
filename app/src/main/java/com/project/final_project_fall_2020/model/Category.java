package com.project.final_project_fall_2020.model;

public class Category {
    public final class EntityName {
        public static final String TABLE_NAME = "categories";
        public static final String ID = "id";
        public static final String CATE_NAME = "cateName";
    }

    private String id;
    private String cateName;

    public Category() {

    }

    public Category(String id, String cateName) {
        this.id = id;
        this.cateName = cateName;
    }

    public String getCateName() {
        return cateName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
