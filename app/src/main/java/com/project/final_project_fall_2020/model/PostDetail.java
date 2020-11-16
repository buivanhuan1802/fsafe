package com.project.final_project_fall_2020.model;

import java.io.Serializable;

public class PostDetail implements Serializable {

    private long id;
    private long productId;

    public PostDetail(long id, int productId) {
        id = id;
        this.productId = productId;
    }
    public PostDetail(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
