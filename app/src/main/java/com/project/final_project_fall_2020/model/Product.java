package com.project.final_project_fall_2020.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    public final class EntityName {
        public static final String TABLE_NAME = "products";
        public static final String ID = "id";
        public static final String SUPPLIER = "supplier";
        public static final String PRODUCT_NAME = "productName";
        public static final String PRICE = "price";
        public static final String DATE_CREATED = "dateCreated";
        public static final String DATE_UPDATED = "dateUpdated";
        public static final String PRODUCT_IMAGES = "productImage";
    }

    private long id;
    private long supplierId;
    private String productName;
    private double price;
    private String dateCreated;
    private String dateUpdated;
    private List<String> productImage;

    public Product() {

    }

    public Product(long id, long supplierId, String productName, double price, String dateCreated, String dateUpdated, List<String> productImage) {
        this.id = id;
        this.supplierId = supplierId;
        this.productName = productName;
        this.price = price;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.productImage = productImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
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
