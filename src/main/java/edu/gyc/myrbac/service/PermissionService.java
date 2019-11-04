package edu.gyc.myrbac.service;


import edu.gyc.myrbac.model.Permission;

import java.util.List;

public interface PermissionService {



    public Integer add(Permission permission);

    public List<Permission> getAll();
}
