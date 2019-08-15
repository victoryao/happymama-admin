package com.happymama.admin.service;

import com.happymama.admin.dao.AdminDao;
import com.happymama.admin.model.AdminDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Service
public class AdminService {

    @Resource
    private AdminDao adminDao;

    public AdminDO login(String name, String password) {
        return adminDao.login(name, password);
    }
}
