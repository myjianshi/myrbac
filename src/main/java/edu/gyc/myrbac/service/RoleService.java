package edu.gyc.myrbac.service;

import edu.gyc.myrbac.model.Permission;
import edu.gyc.myrbac.model.Role;

import java.util.List;


public interface RoleService {




    public Integer add(Role role);

    public Role get(Integer roleId);

    public List<Role> getAll();

    public List<Permission> getPermissions(Integer roleId);
    public void updatePermission(Integer roleId, int[] permissionsIds);

}
