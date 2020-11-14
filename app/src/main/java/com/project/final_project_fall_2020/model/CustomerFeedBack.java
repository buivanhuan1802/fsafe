package com.project.final_project_fall_2020.model;

import java.io.Serializable;

public class CustomerFeedBack implements Serializable {
    private int feedBackId;
    private int userId;
    private int productId;
    private int starts;
    private String confession;

    public CustomerFeedBack() {
    }

    public CustomerFeedBack(int feedBackId, int userId, int productId, int starts, String confession) {
        this.feedBackId = feedBackId;
        this.userId = userId;
        this.productId = productId;
        this.starts = starts;
        this.confession = confession;
    }

    public int getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(int feedBackId) {
        this.feedBackId = feedBackId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStarts() {
        return starts;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public String getConfession() {
        return confession;
    }

    public void setConfession(String confession) {
        this.confession = confession;
    }

    @Override
    public String toString() {
        return this.confession;
    }
}
