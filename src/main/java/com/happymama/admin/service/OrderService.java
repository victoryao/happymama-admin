package com.happymama.admin.service;

import com.happymama.admin.dao.OrderDao;
import com.happymama.admin.dao.RecommendDao;
import com.happymama.admin.model.CustomerDO;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.model.OrderDO;
import com.happymama.admin.model.RecommendDO;
import com.happymama.admin.utils.QueryResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private RecommendService recommendService;
    @Resource
    private CustomerService customerService;
    @Resource
    private EmployeeService employeeService;

    public OrderDO getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    public QueryResult<OrderDO> getOrders(int employeeId, String name, String startDate,
                                          String endDate, int status, int co, int offset, int limit) {
        String idList = employeeService.getEmployeeIdJoinByName(name);
        QueryResult<OrderDO> qr = new QueryResult<>();
        List<OrderDO> list = orderDao.getOrders(employeeId, startDate, endDate, idList, status, co, offset, limit);

        if (CollectionUtils.isNotEmpty(list)) {
            for (OrderDO orderDO : list) {
                CustomerDO customerDO = customerService.getCustomerById(orderDO.getCustomerId());
                if (customerDO != null) {
                    orderDO.setCustomerName(customerDO.getName());
                    orderDO.setCustomerPhone(customerDO.getPhone());
                }
                EmployeeDO employeeDO = employeeService.getEmployeeById(orderDO.getEmployeeId());
                if (employeeDO != null) {
                    orderDO.setEmployeeName(employeeDO.getName());
                }
            }
        }
        long count = getOrderCount(employeeId, idList, startDate, co, endDate, status);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    private long getOrderCount(int employeeId, String idList, String startDate, int co, String endDate, int status) {
        return orderDao.getOrderCount(employeeId, idList, startDate, co, endDate, status);
    }

    @Transactional
    public boolean addOrder(int eId, String name, String phone, String address, String startDate, String endDate,
                            float price, String memo, int orderType, float realPrice, float recommendPrice, String recommendName, String recommendPhone, int co) throws ParseException {
        int recommendCustomerId = 0;
        Date start = DateUtils.parseDate(startDate, new String[]{"yyyy-MM-dd"});
        Date end = DateUtils.parseDate(endDate, new String[]{"yyyy-MM-dd"});
        if (!isOrderAvailable(0, eId, co, startDate, endDate)) {
            return false;
        }

        //客户逻辑处理
        CustomerDO customerDO = CustomerDO.builder().name(name).phone(phone).address(address).build();
        customerDO = customerService.addCustomer(customerDO);

        //介绍人逻辑处理
        if (StringUtils.isNotBlank(recommendName) && StringUtils.isNotBlank(recommendPhone)) {
            CustomerDO recommendCustomer = CustomerDO.builder().name(recommendName).phone(recommendPhone).address(StringUtils.EMPTY).build();
            recommendCustomer = customerService.addCustomer(recommendCustomer);
            recommendCustomerId = recommendCustomer.getId();
        }

        OrderDO orderDO = OrderDO.builder().employeeId(eId).customerId(customerDO.getId()).price(price).type(orderType).status(1).co(co)
                .startDate(start).endDate(end).memo(memo).realPrice(realPrice).recommendPrice(recommendPrice).build();
        orderDao.addOrder(orderDO);

        RecommendDO recommendDO = RecommendDO.builder().orderId(orderDO.getId()).price(recommendPrice).customerId(recommendCustomerId).build();
        recommendService.addRecommend(recommendDO);
        return true;
    }

    public boolean isOrderAvailable(int orderId, int eId, int co, String startDate, String endDate) {
        OrderDO orderDO = orderDao.getFirstOrderAvailable(eId, co, startDate, endDate);
        return orderDO == null || orderDO.getId() == orderId;
    }

    public void deleteOrderById(int orderId) {
        orderDao.deleteOrderById(orderId);
    }

    public boolean updateOrder(int orderId, int employeeId, int customerId, String name, String phone, String address, String startDate, String endDate, float price, String memo, int co) throws ParseException {
        Date start = DateUtils.parseDate(startDate, new String[]{"yyyy-MM-dd"});
        Date end = DateUtils.parseDate(endDate, new String[]{"yyyy-MM-dd"});
        if (!isOrderAvailable(orderId, employeeId, co, startDate, endDate)) {
            return false;
        }
        CustomerDO customerDO = CustomerDO.builder().id(customerId).name(name).phone(phone).address(address).build();
        customerService.updateCustomer(customerDO);
        OrderDO orderDO = OrderDO.builder().id(orderId).employeeId(employeeId).customerId(customerDO.getId()).price(price).startDate(start).endDate(end).memo(memo).build();
        orderDao.updateOrder(orderDO);
        return true;
    }
}
