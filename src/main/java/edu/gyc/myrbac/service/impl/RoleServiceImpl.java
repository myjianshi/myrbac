package edu.gyc.myrbac.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.gyc.myrbac.dao.RoleDao;
import edu.gyc.myrbac.model.Permission;
import edu.gyc.myrbac.model.Role;
import edu.gyc.myrbac.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ls
 * @since 2019-10-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements IService<Role> , RoleService {

@Resource
private RoleDao roleDao;



    public Integer add(Role role) {
        return roleDao.insert(role);
    }

    public Role get(Integer roleId) {
        return roleDao.selectById(roleId);
    }

    public List<Role> getAll() {
        return this.list();
    }

    public List<Permission> getPermissions(Integer roleId) {
        return roleDao.selectPermissionsByPrimaryKey(roleId);
    }

    public void updatePermission(Integer roleId, int[] permissionsIds) {
        roleDao.deletePermissions(roleId);

        if (permissionsIds != null) {
            for (int pId : permissionsIds) {
                roleDao.insertRolePermission(roleId, pId);
            }
        }
    }
}
