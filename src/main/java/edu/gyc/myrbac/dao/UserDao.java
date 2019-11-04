package edu.gyc.myrbac.dao;

import edu.gyc.myrbac.model.Role;
import edu.gyc.myrbac.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ls
 * @since 2019-10-12
 */
public interface UserDao extends BaseMapper<User> {
    List<Role> selectRolesByPrimaryKey(Integer id);
}
