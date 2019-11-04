package edu.gyc.myrbac.controller;

import edu.gyc.myrbac.model.User;
import edu.gyc.myrbac.service.RoleService;
import edu.gyc.myrbac.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @RequestMapping("listUser")
    public ModelAndView listUser() {
        return new ModelAndView("user").addObject("users", userService.getAllUser());
    }

    @RequestMapping("grantRoleView")
    public ModelAndView grantRoleView(int id) {
        ModelAndView modelAndView = new ModelAndView("grant-role");
        modelAndView.addObject("user", userService.get(id));
        modelAndView.addObject("roles", roleService.getAll());
        modelAndView.addObject("grantRole", userService.getUserRoles(id));
        return modelAndView;
    }

    @RequestMapping("grantRole")
    @ResponseBody
    public String grantRole(int id, int[] roleId) {
        userService.updateRoles(id, roleId);
        return "success";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUserSubmit(User user) {
        return userService.add(user) > 0 ? "success" : "error";
    }

    @RequestMapping("add-user")
    public String  aa() {
        return "add-user";
    }
}
