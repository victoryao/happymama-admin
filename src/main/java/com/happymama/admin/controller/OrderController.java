package com.happymama.admin.controller;

import com.happymama.admin.constant.Constant;
import com.happymama.admin.model.CustomerDO;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.model.OrderDO;
import com.happymama.admin.service.CustomerService;
import com.happymama.admin.service.EmployeeService;
import com.happymama.admin.service.OrderService;
import com.happymama.admin.utils.PageView;
import com.happymama.admin.utils.QueryResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/admin/order/list.do", method = RequestMethod.GET)
    public String orderList(@RequestParam(required = false, defaultValue = "0") int eId,
                            @RequestParam(required = false, defaultValue = "") String name,
                            @RequestParam(required = false, defaultValue = "") String startDate,
                            @RequestParam(required = false, defaultValue = "") String endDate,
                            @RequestParam(required = false, defaultValue = "10") int limit,
                            @RequestParam(required = false, defaultValue = "1") int page,
                            ModelMap modelMap

    ) {
        if (limit > 100) {
            limit = Constant.pageSize;
        }
        PageView<OrderDO> pageView = new PageView<>(limit, page);
        startDate = StringUtils.isBlank(startDate) ? null : startDate;
        endDate = StringUtils.isBlank(endDate) ? null : endDate;
        name = StringUtils.isBlank(name) ? null : name;
        QueryResult<OrderDO> qr = orderService.getOrders(eId, name, startDate, endDate, pageView.getFirstResult(), pageView.getMaxresult());
        EmployeeDO employeeDO = employeeService.getEmployeeById(eId);
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("eId", eId);
        if (employeeDO != null) {
            modelMap.addAttribute("employeeName", employeeDO.getName());
            modelMap.addAttribute("employeePhone", employeeDO.getPhone());
        }
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("startDate", startDate);
        modelMap.addAttribute("endDate", endDate);
        return "/order/list";
    }

    @RequestMapping(value = "/admin/order/add", method = RequestMethod.POST)
    public String addOrder(
            @RequestParam int employeeId,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam float price,
            @RequestParam(required = false, defaultValue = "") String memo,
            @RequestParam(required = false, defaultValue = "0") float recommendPrice,
            @RequestParam(required = false, defaultValue = "") String recommendName,
            @RequestParam(required = false, defaultValue = "") String recommendPhone,
            ModelMap modelMap) throws ParseException, IOException {
        if (orderService.addOrder(employeeId, name, phone, address, startDate, endDate, price, memo, price - recommendPrice, recommendPrice, recommendName, recommendPhone)) {
            modelMap.addAttribute("message", "增加成功");
        } else {
            modelMap.addAttribute("message", "此时间段不可预约");
        }
        return "/share/result";
    }

    @RequestMapping(value = "/admin/order/update", method = RequestMethod.POST)
    public String updateOrder(
            @RequestParam int employeeId,
            @RequestParam int orderId,
            @RequestParam int customerId,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam float price,
            @RequestParam(required = false, defaultValue = "") String memo,
            ModelMap modelMap) throws ParseException, IOException {
        if (orderService.updateOrder(orderId, employeeId, customerId, name, phone, address, startDate, endDate, price, memo)) {
            modelMap.addAttribute("message", "修改成功");
        } else {
            modelMap.addAttribute("message", "此时间段不可预约");
        }
        return "/share/result";
    }


    @RequestMapping(value = "/admin/to/{eId}/order/add", method = RequestMethod.GET)
    public String toAddOrder(
            @PathVariable int eId,
            ModelMap modelMap)

    {
        modelMap.addAttribute("employeeId", eId);
        return "/order/add";
    }

    @RequestMapping(value = "/admin/{orderId}/order/delete", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable int orderId, ModelMap modelMap

    ) {
        orderService.deleteOrderById(orderId);
        modelMap.addAttribute("message", "删除成功");
        return "/share/result";
    }

    @RequestMapping(value = "/admin/to/{orderId}/update", method = RequestMethod.GET)
    public String toUpdateOrder(@PathVariable int orderId, ModelMap modelMap

    ) {
        OrderDO orderDO = orderService.getOrderById(orderId);
        CustomerDO customerDO = customerService.getCustomerById(orderDO.getCustomerId());
        EmployeeDO employeeDO = employeeService.getEmployeeById(orderDO.getEmployeeId());
        modelMap.addAttribute("orderDO", orderDO);
        modelMap.addAttribute("customerDO", customerDO);
        modelMap.addAttribute("employeeDO", employeeDO);
        return "/order/edit";
    }
}
