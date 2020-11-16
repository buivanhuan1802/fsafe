package com.project.final_project_fall_2020.model;

public class AppRole {
    private int RoleId;
    private String roleName;

    public AppRole() {
    }

    public AppRole(int roleId, String roleName) {
        RoleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
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
