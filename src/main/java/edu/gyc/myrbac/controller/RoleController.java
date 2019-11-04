package edu.gyc.myrbac.controller;


import edu.gyc.myrbac.model.Role;
import edu.gyc.myrbac.service.PermissionService;
import edu.gyc.myrbac.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @RequestMapping("listRole")
    public ModelAndView listRole() {
        return new ModelAndView("role").addObject("roles", roleService.getAll());
    }

    @RequestMapping("grantPermissionView")
    public ModelAndView grantPermissionView(int id) {
        ModelAndView modelAndView = new ModelAndView("grant-permission");
        modelAndView.addObject("role", roleService.get(id));
        modelAndView.addObject("permissions", permissionService.getAll());
        modelAndView.addObject("grantPermission", roleService.getPermissions(id));
        return modelAndView;
    }

    @RequestMapping("grantPermission")
    @ResponseBody
    public String grantPermission(int id, int[] premissionId) {
        roleService.updatePermission(id, premissionId);
        return "success";
    }

    @RequestMapping("addRole")
    @ResponseBody
    public String addRole(Role role) {
        return roleService.add(role) > 0 ? "success" : "error";
    }

    @RequestMapping("add-role")
    public String  aa() {
        return "add-role";
    }

}
