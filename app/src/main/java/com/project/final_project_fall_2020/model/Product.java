package com.project.final_project_fall_2020.model;

import com.project.final_project_fall_2020.model.IEntity;

import java.io.Serializable;
import java.util.List;

public class Product implements IEntity, Serializable {
    private int productId;
    private int userId;
    private String productName;
    private double price;
    private double comparePrice;
    private String dateCreated;
    private String dateUpdated;
    private List<String> productImage;

    public Product() {

    }

    public Product(int productId, int userId, String productName, double price, double comparePrice, String dateCreated, String dateUpdated, List<String> productImage) {
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.comparePrice = comparePrice;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.productImage = productImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getComparePrice() {
        return comparePrice;
    }

    public void setComparePrice(double comparePrice) {
        this.comparePrice = comparePrice;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<String> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<String> productImage) {
        this.productImage = productImage;
    }
}
