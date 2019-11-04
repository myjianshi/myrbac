package edu.gyc.myrbac.model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ls
 * @since 2019-10-12
 */
public class RolePermission implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer roleId;

    private Integer permissionId;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        "roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}
