package com.example.bmp.controller;

import com.example.bmp.entity.User;
import com.example.bmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String indenx()
    {
        return  login ();
    }
    /**
     * 去登录页面
     */
    @RequestMapping("login")
    public String login() {
        return "login";
    }
    /**
     * 执行登录
     */
    @RequestMapping("/loginuser")
    public String login(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session,
                            RedirectAttributes redirectAttributes
                            )
    {
        User user=userService.getUser (username,password);
        //判断用户是否登录
        if (user!=null)
        {
            user.setPassword (null);
            session.setAttribute ("user",user);
            return "index";
        }
        else
        {
            redirectAttributes.addFlashAttribute ("message","用户名或者密码错误");
            return "登录失败";
        }
    }

    /*
    @RequestMapping("loginuser")
    public String login(HttpServletRequest request) {
        String username = request.getParameter ("username");
        String password = request.getParameter ("password");
        User user = userService.getUser (username, password);
        String str = "";
        if (user != null) {
            str = "index";
        } else {
            str = "register";
        }
        return str;
    }*/
}

