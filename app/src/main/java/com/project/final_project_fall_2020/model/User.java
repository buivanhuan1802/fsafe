package com.project.final_project_fall_2020.model;

import com.project.final_project_fall_2020.model.IEntity;

import java.io.Serializable;

public class User implements IEntity, Serializable {
    private int UserId;
    private int appRole;
    private String userName;
    private String password;
    private String fullName;
    private String certificateUrl;
    private String phoneNumber;
    private String email;
    private String address;
    private String avatarUrl;
    private String dateCreated;
    private String dateUpdated;
    private boolean isActive;

    public User() {
    }

    public User(int userId,int appRole, String userName, String password, String fullName, String certificateUrl, String phoneNumber, String email, String address, String avatarUrl, String dateCreated, String dateUpdated, boolean isActive) {
        UserId = userId;
        this.appRole = appRole;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.certificateUrl = certificateUrl;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.avatarUrl = avatarUrl;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isActive = isActive;
    }

    public int getAppRole() {
        return appRole;
    }

    public void setAppRole(int appRole) {
        this.appRole = appRole;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
