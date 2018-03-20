package com.happymama.admin.controller;

import com.happymama.admin.enums.PositionEnum;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.service.EmployeeService;
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

    @RequestMapping(value = "/admin/to/{eId}/update", method = RequestMethod.GET)
    public String updateEmployee(@PathVariable int eId, ModelMap modelMap

    ) {
        List<Integer> positionList = employeeService.getPositionListByEmployeeId(eId);
        String types = "";
        if (!CollectionUtils.isEmpty(positionList)) {
            for (int position : positionList) {
                types += position + ",";
            }
        }
        EmployeeDO employeeDO = employeeService.getEmployeeById(eId);
        employeeDO.setTypes(types);
        modelMap.addAttribute("employeeDO", employeeDO);
        return "/employee/edit";
    }

}
