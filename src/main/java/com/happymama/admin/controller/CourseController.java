package com.happymama.admin.controller;

import com.happymama.admin.constant.Constant;
import com.happymama.admin.model.CourseOrderDO;
import com.happymama.admin.model.CustomerDO;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.model.OrderDO;
import com.happymama.admin.service.CourseService;
import com.happymama.admin.service.CustomerService;
import com.happymama.admin.service.EmployeeService;
import com.happymama.admin.utils.PageView;
import com.happymama.admin.utils.QueryResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/5/14.
 */
@Controller
public class CourseController {

    @Resource
    private CourseService courseService;
    @Resource
    private CustomerService customerService;
    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = "/admin/course/list.do", method = RequestMethod.GET)
    public String orderList(@RequestParam(required = false, defaultValue = "0") int eId,
                            ModelMap modelMap

    ) {
        EmployeeDO employeeDO = employeeService.getEmployeeById(eId);
        List<CourseOrderDO> courseOrderDOs = courseService.getCourseOrderListByEmployeeId(eId);
        assembleRecommendInfo(courseOrderDOs);
        modelMap.addAttribute("courseOrders", courseOrderDOs);
        modelMap.addAttribute("courses", courseService.getCourseList());
        modelMap.addAttribute("employeeId", eId);
        modelMap.addAttribute("employeeDO", employeeDO);
        return "/course/list";
    }

    @RequestMapping(value = "/admin/course/add.do", method = RequestMethod.GET)
    public String addCourse(
            @RequestParam int courseId,
            @RequestParam int employeeId,
            @RequestParam(required = false, defaultValue = "0") float price,
            @RequestParam(required = false, defaultValue = "0") float recommendPrice,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String phone,
            ModelMap modelMap

    ) {
        EmployeeDO employeeDO = employeeService.getEmployeeById(employeeId);
        CourseOrderDO.CourseOrderDOBuilder builder = CourseOrderDO.builder();

        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(phone)) {
            CustomerDO customerDO = CustomerDO.builder().name(name).phone(phone).address(StringUtils.EMPTY).build();
            customerDO = customerService.addCustomer(customerDO);
            builder.customerId(customerDO.getId());
        }

        CourseOrderDO courseOrderDO = builder.employeeId(employeeId).price(price).recommendPrice(recommendPrice)
                .realPrice(price - recommendPrice).courseId(courseId).build();

        courseService.addCourse(courseOrderDO);
        List<CourseOrderDO> courseOrderDOs = courseService.getCourseOrderListByEmployeeId(employeeId);
        assembleRecommendInfo(courseOrderDOs);
        modelMap.addAttribute("courseOrders", courseOrderDOs);
        modelMap.addAttribute("courses", courseService.getCourseList());
        modelMap.addAttribute("employeeId", employeeId);
        modelMap.addAttribute("employeeDO", employeeDO);
        return "/course/list";
    }


    @RequestMapping(value = "admin/course/{orderId}/delete.do", method = RequestMethod.GET)
    public String delCourseOrder(
            @PathVariable int orderId,
            @RequestParam int employeeId,
            ModelMap modelMap

    ) {
        EmployeeDO employeeDO = employeeService.getEmployeeById(employeeId);
        courseService.delCourseOrder(orderId);
        List<CourseOrderDO> courseOrderDOs = courseService.getCourseOrderListByEmployeeId(employeeId);
        assembleRecommendInfo(courseOrderDOs);
        modelMap.addAttribute("courseOrders", courseOrderDOs);
        modelMap.addAttribute("courses", courseService.getCourseList());
        modelMap.addAttribute("employeeId", employeeId);
        modelMap.addAttribute("employeeDO", employeeDO);
        return "/course/list";
    }


    private void assembleRecommendInfo(List<CourseOrderDO> courseOrderDOs) {
        if (CollectionUtils.isNotEmpty(courseOrderDOs)) {
            for (CourseOrderDO orderDO : courseOrderDOs) {
                orderDO.setCourseName(courseService.getCourseById(orderDO.getCourseId()).getName());
                CustomerDO customerDO = customerService.getCustomerById(orderDO.getCustomerId());
                if (customerDO != null) {
                    orderDO.setRecommendName(customerDO.getName());
                    orderDO.setRecommendPhone(customerDO.getPhone());
                }
            }
        }
    }
}
