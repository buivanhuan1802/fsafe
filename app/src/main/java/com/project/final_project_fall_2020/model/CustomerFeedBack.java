package com.project.final_project_fall_2020.model;

import java.io.Serializable;

public class CustomerFeedBack implements Serializable {
    public final class EntityName {
        public static final String TABLE_NAME = "customer_feedback";
        public static final String ID = "id";
        public static final String USER = "user";
        public static final String PRODUCT = "product";
        public static final String STARTS = "starts";
        public static final String CONFESSION = "confession";
    }

    private long id;
    private User user;
    private Product product;
    private String starts;
    private String confession;

    public CustomerFeedBack() {
    }

    public CustomerFeedBack(long id, User user, Product productId, String starts, String confession) {
        this.id = id;
        this.user = user;
        this.product = productId;
        this.starts = starts;
        this.confession = confession;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(int userId) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStarts() {
        return starts;
    }

    public void setStarts(String starts) {
        this.starts = starts;
    }

    public String getConfession() {
        return confession;
    }

    public void setConfession(String confession) {
        this.confession = confession;
    }

    @Override
    public String toString() {
        return this.confession;
    }
}
