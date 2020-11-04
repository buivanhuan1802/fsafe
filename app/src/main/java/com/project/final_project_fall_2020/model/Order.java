package com.project.final_project_fall_2020.model;

import java.io.Serializable;
import java.util.List;

public class Order implements IEntity, Serializable {
    private int orderId;
    private int userId;
    private int supplierId;
    private String dateCreated;
    private int status;
    List<OrderDetail> details;

    public Order() {
    }

    public Order(int orderId, int userId, int supplierId, String dateCreated, int status, List<OrderDetail> details) {
        this.orderId = orderId;
        this.userId = userId;
        this.supplierId = supplierId;
        this.dateCreated = dateCreated;
        this.status = status;
        this.details = details;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }
}
