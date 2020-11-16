package com.project.final_project_fall_2020.model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private long id;
    private String userId;
    private String supplierId;
    private String dateCreated;
    private String status;
    List<OrderDetail> details;

    public Order() {
    }

    public Order(long id, String userId, String supplierId, String dateCreated, String status, List<OrderDetail> details) {
        this.id = id;
        this.userId = userId;
        this.supplierId = supplierId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
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
