package com.happymama.admin.service;

import com.happymama.admin.dao.OrderDao;
import com.happymama.admin.model.CustomerDO;
import com.happymama.admin.model.OrderDO;
import com.happymama.admin.utils.QueryResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private CustomerService customerService;

    public OrderDO getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    public QueryResult<OrderDO> getOrders(int employeeId, String startDate, String endDate, int offset, int limit) {
        QueryResult<OrderDO> qr = new QueryResult<>();
        List<OrderDO> list = orderDao.getOrders(employeeId, startDate, endDate, offset, limit);
        if (CollectionUtils.isNotEmpty(list)) {
            for (OrderDO orderDO : list) {
                CustomerDO customerDO = customerService.getCustomerById(orderDO.getCustomerId());
                if (customerDO != null) {
                    orderDO.setCustomerName(customerDO.getName());
                    orderDO.setCustomerPhone(customerDO.getPhone());
                }
            }
        }
        long count = getOrderCount(employeeId, startDate, endDate);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    private long getOrderCount(int employeeId, String startDate, String endDate) {
        return orderDao.getOrderCount(employeeId, startDate, endDate);
    }

    @Transactional
    public boolean addOrder(int eId, String name, String phone, String address, String startDate, String endDate, float price, String memo) throws ParseException {
        Date start = DateUtils.parseDate(startDate, new String[]{"yyyy-MM-dd"});
        Date end = DateUtils.parseDate(endDate, new String[]{"yyyy-MM-dd"});
        if (!isOrderAvailable(0, eId, startDate, endDate)) {
            return false;
        }
        CustomerDO customerDO = CustomerDO.builder().name(name).phone(phone).address(address).build();
        customerService.addCustomer(customerDO);
        OrderDO orderDO = OrderDO.builder().employeeId(eId).customerId(customerDO.getId()).price(price).startDate(start).endDate(end).memo(memo).build();
        orderDao.addOrder(orderDO);
        return true;
    }

    public boolean isOrderAvailable(int orderId, int eId, String startDate, String endDate) {
        OrderDO orderDO = orderDao.getFirstOrderAvailable(eId, startDate, endDate);
        return orderDO == null || orderDO.getId() == orderId;
    }

    public void deleteOrderById(int orderId) {
        orderDao.deleteOrderById(orderId);
    }

    public boolean updateOrder(int orderId, int employeeId, int customerId, String name, String phone, String address, String startDate, String endDate, float price, String memo) throws ParseException {
        Date start = DateUtils.parseDate(startDate, new String[]{"yyyy-MM-dd"});
        Date end = DateUtils.parseDate(endDate, new String[]{"yyyy-MM-dd"});
        if (!isOrderAvailable(orderId, employeeId, startDate, endDate)) {
            return false;
        }
        CustomerDO customerDO = CustomerDO.builder().id(customerId).name(name).phone(phone).address(address).build();
        customerService.updateCustomer(customerDO);
        OrderDO orderDO = OrderDO.builder().id(orderId).employeeId(employeeId).customerId(customerDO.getId()).price(price).startDate(start).endDate(end).memo(memo).build();
        orderDao.updateOrder(orderDO);
        return true;
    }
}
