package com.project.final_project_fall_2020.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Post implements Serializable {
    public final class EntityName {
        public static final String TABLE_NAME = "posts";
        public static final String ID = "id";
        public static final String SUPPLIER = "supplierId";
        public static final String POST_TITLE = "postTitle";
        public static final String POST_CONTENT = "postContent";
        public static final String DATE_CREATED = "dateCreated";
        public static final String DATE_UPDATED = "dateUpdated";
        public static final String START_TIME = "startTime";
        public static final String END_TIME = "endTime";
        public static final String ENABLED = "enabled";
        public static final String DETAILS = "details";
    }

    private long id;
    private long supplierId;
    private String postTitle;
    private String postContent;
    private String dateCreated;
    private String dateUpdated;
    private String startTime;
    private String endTime;
    private boolean enabled;
    private List<PostDetail> details;

    public Post() {

    }

    public Post(long id, long supplierId, String postTitle, String postContent, String dateCreated, String dateUpdated, String startTime, String endTime, List<PostDetail> details, boolean enabled) {
        this.id = id;
        this.supplierId = supplierId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.startTime = startTime;
        this.endTime = endTime;
        this.details = details;
        this.enabled = enabled;
    }

    public List<PostDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PostDetail> details) {
        this.details = details;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
