package com.project.final_project_fall_2020.model;

import com.project.final_project_fall_2020.utils.Utils;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    public final class EntityName {
        public static final String TABLE_NAME = "orders";
        public static final String ID = "id";
        public static final String USER = "userId";
        public static final String SUPPLIER = "supplierId";
        public static final String DATE_CREATED = "dateCreated";
        public static final String STATUS = "status";
        public static final String DETAILS = "details";
    }

    public static final class STATUS {
        public static final String IN_PROCESSING = "In Processing";
        public static final String ON_DELIVERY = "On Delivery";
        public static final String FINISHED = "Finished";
        public static final int IN_PROCESSING_VALUE = 1;
        public static final int ON_DELIVERY_VALUE = 2;
        public static final int FINISHED_VALUE = 3;
    }

    private long id;
    private long userId;
    private long supplierId;
    private String dateCreated;
    private String status;
    List<OrderDetail> details;
    private double totalAmount;

    public Order() {
    }

    public Order(long id, long userId, long supplierId, String dateCreated, String status, double totalAmount, List<OrderDetail> details) {
        this.id = id;
        this.userId = userId;
        this.supplierId = supplierId;
        this.dateCreated = dateCreated;
        this.status = status;
        this.totalAmount = totalAmount;
        this.details = details;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
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

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        if (this != null) {
            return "- OrderID: " + this.id + " - Date_Created: " + this.dateCreated + "\n" + " \t\ttotal: " + this.totalAmount + "vnd";
        }
        return "";
    }

}
