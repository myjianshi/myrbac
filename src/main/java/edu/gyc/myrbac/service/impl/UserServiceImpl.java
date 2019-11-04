package edu.gyc.myrbac.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import edu.gyc.myrbac.dao.RoleDao;
import edu.gyc.myrbac.dao.UserDao;
import edu.gyc.myrbac.dao.UserRoleDao;
import edu.gyc.myrbac.model.Permission;
import edu.gyc.myrbac.model.Role;
import edu.gyc.myrbac.model.User;
import edu.gyc.myrbac.model.UserRole;
import edu.gyc.myrbac.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ls
 * @since 2019-10-12
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Resource
    private RoleDao roleDao;


    @Override
    public int add(User user) {
        return userDao.insert(user);
    }

    @Override
    public User get(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.selectList(null);
    }

    @Override
    public List<Role> getUserRoles(Integer id) {

        return userDao.selectRolesByPrimaryKey(id);
    }

    @Override
    public void updateRoles(Integer id, int[] roleIds) {
          userRoleDao.delete(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId,id));
        if (roleIds != null) {
            for (int roleId : roleIds) {
                UserRole userRole=new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(id);

                userRoleDao.insert(userRole);
            }
        }

    }

    @Override
    public User selectUserByUsernameAndPassword(String username, String password) {
        return userDao.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername,username).eq(
                User::getPassword,password));
    }

    @Override
    public List<String> getUserPersmission(Integer userId) {
        List<Role> roles=getUserRoles(userId);
        List<String> permissions = new ArrayList<>();
        for (Role role : roles) {
         List<Permission>  permissions1=  roleDao.selectPermissionsByPrimaryKey(role.getId());
            for (Permission permission : permissions1) {
                permissions.add(permission.getName());
            }
        }
        return permissions;
    }
}
