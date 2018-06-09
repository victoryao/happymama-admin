package com.happymama.admin.controller;

import com.google.common.base.Splitter;
import com.happymama.admin.constant.Constant;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.service.EmployeeService;
import com.happymama.admin.utils.FileUtils;
import com.happymama.admin.utils.PageView;
import com.happymama.admin.utils.QueryResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Controller
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = "/admin/employee/add", method = RequestMethod.POST)
    public String addEmployee(
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String phone,
            @RequestParam String birthday,
            @RequestParam String startDate,
            @RequestParam String IDCard,
            @RequestParam String hometown,
            @RequestParam MultipartFile photo,
            @RequestParam(required = false, defaultValue = "") String introduce,
            @RequestParam(required = false, defaultValue = "") String skill,
            @RequestParam String types,
            @RequestParam(required = false, defaultValue = "0") float salary,
            ModelMap modelMap) throws ParseException, IOException

    {
        String path = FileUtils.saveFile(photo);
        employeeService.addEmployee(name, gender, path, phone, birthday, startDate, IDCard, hometown, introduce, types, salary, skill);
        modelMap.addAttribute("message", "增加成功");
        return "/share/result";
    }

    @RequestMapping(value = "/admin/employee/update", method = RequestMethod.POST)
    public String updateEmployee(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String phone,
            @RequestParam String birthday,
            @RequestParam String startDate,
            @RequestParam String IDCard,
            @RequestParam String hometown,
            @RequestParam(required = false, defaultValue = "") String introduce,
            @RequestParam(required = false, defaultValue = "") String skill,
            @RequestParam String types,
            @RequestParam MultipartFile photo,
            ModelMap modelMap) throws ParseException, IOException

    {
        String path = FileUtils.saveFile(photo);
        employeeService.updateEmployee(id, name, gender, path, phone, birthday, startDate, IDCard, hometown, introduce, types, skill);
        modelMap.addAttribute("message", "修改成功");
        return "/share/result";
    }

    @RequestMapping(value = "/admin/{eId}/update", method = RequestMethod.GET)
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

    @RequestMapping(value = "/admin/{eId}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int eId, ModelMap modelMap

    ) {
        employeeService.deleteEmployeeById(eId);
        modelMap.addAttribute("message", "删除成功");
        modelMap.addAttribute("nextUrl", "/admin/employee/list.do");
        modelMap.addAttribute("nextStep", "继续删除");
        return "/share/result";
    }


}
