package com.project.final_project_fall_2020.model;

import java.io.Serializable;

public class User implements Serializable {
    public final class EntityName {
        public static final String TABLE_NAME = "app_user";
        public static final String ID = "id";
        public static final String APP_ROLE = "role";
        public static final String USER_NAME = "userName";
        public static final String PASSWORD = "password";
        public static final String FULL_NAME = "fullName";
        public static final String CERTIFICATE_URL = "certificateUrl";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String EMAIL = "email";
        public static final String ADDRESS = "address";
        public static final String AVATAR_URL = "avatarUrl";
        public static final String DATE_CREATED = "dateCreated";
        public static final String DATE_UPDATED = "dateUpdated";
        public static final String IS_ACTIVE = "isActive";
    }

    private long id;
    private AppRole role;
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

    public User(long id, AppRole role, String userName, String password, String fullName, String certificateUrl, String phoneNumber, String email, String address, String avatarUrl, String dateCreated, String dateUpdated, boolean isActive) {
        this.id = id;
        this.role = role;
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

    public User(long id){
        this.id = id;
    }

    public AppRole getRole() {
        return role;
    }
    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }


    public void setRole(AppRole appRole) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
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

    @Override
    public String toString() {
        return this.fullName;
    }
}
