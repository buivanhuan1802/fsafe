package com.project.final_project_fall_2020.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Post implements Serializable {
    private int postId;
    private int userId;
    private String postTitle;
    private String postContent;
    private String dateCreated;
    private String dateUpdated;
    private Date startTime;
    private Date endTime;
    private boolean enabled;
    private List<PostDetail> details;

    public Post() {

    }

    public Post(int postId, int userId, String postTitle, String postContent, String dateCreated, String dateUpdated, Date startTime, Date endTime, boolean enabled) {
        this.postId = postId;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.startTime = startTime;
        this.endTime = endTime;
        this.enabled = enabled;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
