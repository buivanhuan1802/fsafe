package com.project.final_project_fall_2020.model;

import java.io.Serializable;

public class PostDetail implements Serializable {
    private int Id;
    private int productId;

    public PostDetail(int id, int productId) {
        Id = id;
        this.productId = productId;
    }
    public PostDetail(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
