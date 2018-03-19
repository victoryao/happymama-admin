package com.happymama.admin.controller;

import com.happymama.admin.constant.Constant;
import com.happymama.admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Controller
public class LoginController {

    @Resource
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        ModelMap modelMap,
                        HttpSession httpSession) {
        if (adminService.login(name, password)) {
            httpSession.setAttribute(Constant.sessionCheckKey, name);
            modelMap.addAttribute("loginName", name);
            return "/home/home";
        }
        return "signin";
    }

}
