package com.project.final_project_fall_2020.model;

import java.io.Serializable;

public class PostDetail implements Serializable {

    private long id;
    private long productId;
    private boolean status;

    public PostDetail(long id, int productId, boolean status) {
        this.id = id;
        this.productId = productId;
        this.status = status;
    }

    public PostDetail() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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
