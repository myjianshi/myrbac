package edu.gyc.myrbac.controller;

import edu.gyc.myrbac.model.Permission;
import edu.gyc.myrbac.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @RequestMapping("listPermission")
    public ModelAndView list() {
        return new ModelAndView("permission").addObject("permissions", permissionService.getAll());
    }

    @RequestMapping("addPermission")
    @ResponseBody
    public String add(Permission permission) {
        return permissionService.add(permission) > 0 ? "success" : "error";
    }

    @RequestMapping("add-permission")
    public String  aa() {
        return "add-permission";
    }
}
