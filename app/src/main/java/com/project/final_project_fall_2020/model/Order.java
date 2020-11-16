package com.project.final_project_fall_2020.model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    public final  class  EntityName{
        public static final String TABLE_NAME = "orders";
        public static final String ID= "id";
        public static final String USER = "user";
        public static final String SUPPLIER = "supplier";
        public static final String DATE_CREATED = "dateCreated";
        public static final String STATUS = "status";
        public static final String DETAILS = "details";
    }
    private long id;
    private User user;
    private User supplier;
    private String dateCreated;
    private String status;
    List<OrderDetail> details;

    public Order() {
    }

    public Order(long id, User user, User supplier, String dateCreated, String status, List<OrderDetail> details) {
        this.id = id;
        this.user = user;
        this.supplier = supplier;
        this.dateCreated = dateCreated;
        this.status = status;
        this.details = details;
    }

    public long getOrderId() {
        return id;
    }

    public void setOrderId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public User getSupplier() {
        return supplier;
    }

    public void setSupplier(User supplierId) {
        this.supplier = supplier;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public long getId() {
        return id;
    }

}
