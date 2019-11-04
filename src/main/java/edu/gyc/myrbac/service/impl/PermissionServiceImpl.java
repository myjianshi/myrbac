package edu.gyc.myrbac.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.gyc.myrbac.model.Permission;
import edu.gyc.myrbac.dao.PermissionDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.gyc.myrbac.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ls
 * @since 2019-10-12
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements IService<Permission>, PermissionService {
@Resource
private PermissionDao permissionDao;
    @Override
    public Integer add(Permission permission) {
        return permissionDao.insert(permission);
    }

    @Override
    public List<Permission> getAll() {
        return this.list();
    }
}
