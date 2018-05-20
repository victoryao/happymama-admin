package com.happymama.admin.controller;

import com.happymama.admin.enums.PositionEnum;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.service.EmployeeService;
import com.happymama.admin.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Controller
public class NavController {

    @Resource
    private EmployeeService employeeService;
    @Resource
    private StatisticsService statisticsService;

    @RequestMapping("/to/login")
    public String toLoginPage() {
        return "signin";
    }

    @RequestMapping("/home")
    public String toHomePage(ModelMap modelMap) {
        modelMap.addAttribute("babySitterCount", employeeService.getCountByPosition(PositionEnum.BABYSITTER.getVal()));
        modelMap.addAttribute("yuerCount", employeeService.getCountByPosition(PositionEnum.YUERSAO.getVal()));
        modelMap.addAttribute("courseInput", statisticsService.getCourseInput());
        modelMap.addAttribute("orderInput", statisticsService.getOrderInput());
        return "/home/home";
    }

    @RequestMapping("/admin/to/employee/add")
    public String toEmployeePage() {
        return "/employee/add";
    }


}
