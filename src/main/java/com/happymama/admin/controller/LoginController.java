package com.happymama.admin.controller;

import com.happymama.admin.constant.Constant;
import com.happymama.admin.enums.PositionEnum;
import com.happymama.admin.service.AdminService;
import com.happymama.admin.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        ModelMap modelMap,
                        HttpSession httpSession) {
        if (adminService.login(name, password)) {
            httpSession.setAttribute(Constant.sessionCheckKey, name);
            modelMap.addAttribute("loginName", name);
            modelMap.addAttribute("studentCount", employeeService.getCountByPosition(PositionEnum.STUDENT.getVal()));
            modelMap.addAttribute("babySitterCount", employeeService.getCountByPosition(PositionEnum.BABYSITTER.getVal()));
            modelMap.addAttribute("teacherCount", employeeService.getCountByPosition(PositionEnum.TEACHER.getVal()));
            return "/home/home";
        }
        return "signin";
    }

}
