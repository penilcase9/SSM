package com.jv.controller;

import com.jv.entity.User;
import com.jv.service.interf.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController extends OaAbstrController{
    @Resource
    public UserService userService;

    @RequestMapping("/findUser")
    public String findUser(Model model) {
        int id = 1;
        User user = this.userService.findUserById(id);
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {

        return "login/Login";
    }

    @Override
    @RequestMapping("/*")
    public String unHandlerUrl(Model model) {
        return "login/loginUnknowUrl";
    }
}
