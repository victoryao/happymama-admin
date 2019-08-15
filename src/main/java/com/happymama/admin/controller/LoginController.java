package com.happymama.admin.controller;

import com.happymama.admin.constant.Constant;
import com.happymama.admin.enums.PositionEnum;
import com.happymama.admin.model.AdminDO;
import com.happymama.admin.service.AdminService;
import com.happymama.admin.service.EmployeeService;
import com.happymama.admin.service.StatisticsService;
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
    @Resource
    private StatisticsService statisticsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        ModelMap modelMap,
                        HttpSession httpSession) {
        AdminDO adminDO = adminService.login(name, password);
        if (adminDO != null) {
            httpSession.setAttribute(Constant.sessionCheckKey, adminDO);
            modelMap.addAttribute("loginName", name);
            modelMap.addAttribute("babySitterCount", employeeService.getCountByPosition(PositionEnum.BABYSITTER.getVal()));
            modelMap.addAttribute("yuerCount", employeeService.getCountByPosition(PositionEnum.YUERSAO.getVal()));
            modelMap.addAttribute("courseInput", statisticsService.getCourseInput());
            modelMap.addAttribute("orderInput", statisticsService.getOrderInput());
            return "/home/home";
        }
        return "signin";
    }

}
