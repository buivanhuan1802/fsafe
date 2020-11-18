package com.project.final_project_fall_2020.model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    public final class EntityName {
        public static final String TABLE_NAME = "details";
        public static final String ID = "id";
        public static final String PRODUCT = "productId";
        public static final String QUANTITY = "quantity";
        public static final String TOTAL_AMOUNT = "totalAmount";
    }

    private long id;
    private long productId;
    private long quantity;
    private double totalAmount;

    public OrderDetail() {
    }

    public OrderDetail(long id, long productId, long quantity, double totalAmount) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        id = id;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
