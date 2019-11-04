package edu.gyc.myrbac.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.gyc.myrbac.model.Permission;
import edu.gyc.myrbac.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author ls
 * @since 2019-10-12
 */
public interface RoleDao extends BaseMapper<Role> {

   /**
    * 查询角色拥有的权限列表
     *
    * @param id 角色 id
     * @return 权限列表
     */
    List<Permission> selectPermissionsByPrimaryKey(Integer id);

    /**
     * 删除角色所有的权限
     *
     * @param id 角色 id
     * @return 删除成功的条数
     */
    int deletePermissions(Integer id);

    /**
     * 为角色添加一个权限
     *
     * @param roleId       角色 id
     * @param permissionId 权限 id
     * @return 插入成功的条数
     */
    int insertRolePermission(@Param("role_id") Integer roleId, @Param("permission_id") Integer permissionId);
}
