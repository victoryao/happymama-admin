package com.happymama.admin.controller;

import com.google.common.base.Splitter;
import com.happymama.admin.constant.Constant;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.service.EmployeeService;
import com.happymama.admin.utils.PageView;
import com.happymama.admin.utils.QueryResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Controller
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = "/admin/employee/add", method = RequestMethod.POST)
    public String addEmployee(@RequestParam String name,
                              @RequestParam String gender,
                              @RequestParam String phone,
                              @RequestParam String birthday,
                              @RequestParam String IDCard,
                              @RequestParam String hometown,
                              @RequestParam(required = false) String introduce,
                              @RequestParam String types) throws ParseException

    {

        employeeService.addEmployee(name, gender, phone, birthday, IDCard, hometown, introduce, types);

        return "/home/home";
    }

    @RequestMapping("/admin/employee/list")
    public String toEmployeeListPage(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String phone,
            @RequestParam(required = false, defaultValue = "") String types,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "1") int page,
            ModelMap modelMap) {
        if (limit > 100) {
            limit = Constant.pageSize;
        }
        PageView<EmployeeDO> pageView = new PageView<>(limit, page);
        name = StringUtils.isBlank(name) ? null : name;
        phone = StringUtils.isBlank(phone) ? null : phone;
        types = StringUtils.isBlank(types) ? null : types;
        QueryResult<EmployeeDO> qr = employeeService.getEmployeeList(name, phone, types, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("phone", phone);
        modelMap.addAttribute("types", types);
        return "/employee/list";
    }


}
