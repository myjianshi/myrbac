package edu.gyc.myrbac.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.gyc.myrbac.model.UserRole;
import edu.gyc.myrbac.dao.UserRoleDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author ls
 * @since 2019-10-12
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements IService<UserRole> {

}
