package com.happymama.admin.service;

import com.happymama.admin.dao.EmployeeDao;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.utils.QueryResult;
import lombok.extern.java.Log;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Service
@Log
public class EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    public boolean addEmployee(String name, String gender, String phone, String birthday, String IDCard, String hometown, String introduce, String type) throws ParseException {
        if (birthday == null) return false;
        Date birthdayDate = DateUtils.parseDate(birthday, new String[]{"yyyy-MM-dd"});
        for (int i = 0; i < 100; i++) {
            EmployeeDO employeeDO = EmployeeDO.builder().name(name + i).gender(Integer.parseInt(gender))
                    .phone(phone).birthday(birthdayDate).idcard(IDCard).hometown(hometown).introduce(introduce).build();

            employeeDao.addEmployee(employeeDO);
        }
        return true;
    }

    public QueryResult<EmployeeDO> getEmployeeList(int offset, int limit) {
        QueryResult<EmployeeDO> qr = new QueryResult<>();
        List<EmployeeDO> list = employeeDao.getEmployeeList(offset, limit);
        long count = getEmployeeCount();
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    private long getEmployeeCount() {
        return employeeDao.getEmployeeCount();
    }


}
