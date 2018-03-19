package com.happymama.admin.service;

import com.google.common.base.Splitter;
import com.happymama.admin.dao.EmployeeDao;
import com.happymama.admin.dao.EmployeePositionDao;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.model.EmployeePositionDO;
import com.happymama.admin.utils.QueryResult;
import lombok.extern.java.Log;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.ibatis.annotations.Param;
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
    @Resource
    private EmployeePositionDao employeePositionDao;

    public boolean addEmployee(String name, String gender, String phone, String birthday, String IDCard, String hometown, String introduce, String types) throws ParseException {
        if (birthday == null) return false;
        Date birthdayDate = DateUtils.parseDate(birthday, new String[]{"yyyy-MM-dd"});

        EmployeeDO employeeDO = EmployeeDO.builder().name(name).gender(Integer.parseInt(gender))
                .phone(phone).birthday(birthdayDate).idcard(IDCard).hometown(hometown).introduce(introduce).build();

        boolean result = employeeDao.addEmployee(employeeDO);

        if (result && StringUtils.isNotBlank(types)) {
            List<String> typeList = Splitter.on(",").splitToList(types);
            for (String type : typeList) {
                addEmployeePosition(employeeDO.getId(), Integer.parseInt(type));
            }
        }
        return result;
    }

    public QueryResult<EmployeeDO> getEmployeeList(String name, String phone, String types, int offset, int limit) {
        QueryResult<EmployeeDO> qr = new QueryResult<>();
        List<EmployeeDO> list = employeeDao.getEmployeeList(name, phone, types, offset, limit);
        long count = getEmployeeCount(name, phone, types);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    private long getEmployeeCount(String name, String phone, String types) {
        return employeeDao.getEmployeeCount(name, phone, types);
    }

    public boolean addEmployeePosition(int employeeId, int position) {
        return employeePositionDao.addEmployeePosition(EmployeePositionDO.builder().employeeId(employeeId).position(position).build());
    }

    public long getCountByPosition(int type) {
        return employeePositionDao.getCountByPosition(type);
    }

}
