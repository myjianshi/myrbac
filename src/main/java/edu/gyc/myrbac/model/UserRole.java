package edu.gyc.myrbac.model;

import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author ls
 * @since 2019-10-12
 */
public class UserRole implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer userId;

    private Integer roleId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        "userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
