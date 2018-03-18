package com.happymama.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Controller
public class NavController {

    @RequestMapping("/home")
    public String toHomePage() {
        return "/home/home";
    }

    @RequestMapping("/admin/to/employee/add")
    public String toEmployeePage() {
        return "/employee/add";
    }


}
