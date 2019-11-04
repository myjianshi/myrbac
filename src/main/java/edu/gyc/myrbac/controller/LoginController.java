package edu.gyc.myrbac.controller;

import edu.gyc.myrbac.model.User;
import edu.gyc.myrbac.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("tologin")
    public String  aa() {
        return "login";
    }

    @RequestMapping("/login")

    public String login(String username, String password, HttpSession httpSession) {
        User user = userService.selectUserByUsernameAndPassword(username, password);
        List<String> permissions = userService.getUserPersmission(user.getId());
        if (user != null) {
            httpSession.setAttribute("user", user);
            httpSession.setAttribute("permissions",permissions);
            return "menu";
        }
        return "index";
    }

    @RequestMapping("/exit")
    @ResponseBody
    public String exit(HttpSession httpSession) {
        httpSession.invalidate();
        return "注销成功！<br><a href=\"/myrbac/index\">Menu</a>";
    }
}
