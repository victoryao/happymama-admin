package com.happymama.admin.controller;

import com.happymama.admin.enums.PositionEnum;
import com.happymama.admin.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Controller
public class NavController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/to/login")
    public String toLoginPage() {
        return "signin";
    }

    @RequestMapping("/home")
    public String toHomePage(ModelMap modelMap) {
        modelMap.addAttribute("studentCount", employeeService.getCountByPosition(PositionEnum.STUDENT.getVal()));
        modelMap.addAttribute("babySitterCount", employeeService.getCountByPosition(PositionEnum.BABYSITTER.getVal()));
        modelMap.addAttribute("teacherCount", employeeService.getCountByPosition(PositionEnum.TEACHER.getVal()));
        return "/home/home";
    }

    @RequestMapping("/admin/to/employee/add")
    public String toEmployeePage() {
        return "/employee/add";
    }


}
