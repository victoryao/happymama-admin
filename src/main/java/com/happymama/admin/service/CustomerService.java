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

    public CustomerDO addCustomer(CustomerDO customerDO) {
        CustomerDO cDo = customerDao.getCustomerByPhone(customerDO.getPhone());
        if (cDo != null) {

            return cDo;
        }
        customerDao.addCustomer(customerDO);
        return customerDO;
    }

    public CustomerDO getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public CustomerDO getCustomerByPhone(String phone) {
        return customerDao.getCustomerByPhone(phone);
    }

    public void updateCustomer(CustomerDO customerDO) {
        customerDao.updateCustomer(customerDO);
    }
}
