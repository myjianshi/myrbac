package edu.gyc.myrbac.controller;


import edu.gyc.myrbac.annotation.RequiredPermission;
import edu.gyc.myrbac.annotation.RequiredRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class APIController {
    @RequiredPermission("admin")
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequiredPermission("add")
    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequiredPermission("delete")
    @RequestMapping("/delete")
    public String delete() {
        return "del";
    }

    @RequiredPermission("get")
    @RequestMapping("/get")
    public String cx() {
        return "get";
    }

    @RequiredRole("boss")
    @RequestMapping("/boss")
    public String boss() {
        return "此数据为 Boss 专用数据, 你是 boss, 你可以查看";
    }

    @RequiredPermission("employee")
    @RequestMapping("/employee")
    public String employee() {
        return "此数据为员工专用数据, 你是员工, 可以查看";
    }
}
