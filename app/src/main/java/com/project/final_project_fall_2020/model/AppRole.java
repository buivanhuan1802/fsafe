package com.project.final_project_fall_2020.model;

public class AppRole {
    public final class EntityName {
        public static final String TABLE_NAME = "app_role";
        public static final String ROLE_ID = "id";
        public static final String ROLE_NAME = "roleName";
    }

    private long id;
    private String roleName;

    public AppRole() {
    }

    public AppRole(long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return this.roleName;
    }
}
