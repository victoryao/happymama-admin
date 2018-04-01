package com.happymama.admin.service;

import com.happymama.admin.dao.CustomerDao;
import com.happymama.admin.model.CustomerDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;

    public boolean addCustomer(CustomerDO customerDO) {
        return customerDao.addCustomer(customerDO);
    }

    public CustomerDO getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public void updateCustomer(CustomerDO customerDO) {
        customerDao.updateCustomer(customerDO);
    }
}
