package com.happymama.admin.service;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.happymama.admin.dao.EmployeeDao;
import com.happymama.admin.dao.EmployeePositionDao;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.model.EmployeePhotoDO;
import com.happymama.admin.model.EmployeePositionDO;
import com.happymama.admin.utils.QueryResult;
import lombok.extern.java.Log;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Collection;
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


    public boolean addEmployeePhoto(EmployeePhotoDO employeePhotoDO) {
        return employeeDao.addEmployeePhoto(employeePhotoDO);
    }

    public List<EmployeePhotoDO> getEmployeePhotoList(@Param("employeeId") int employeeId, @Param("type") int type) {
        return employeeDao.getEmployeePhotoList(employeeId, type);
    }


    public EmployeeDO getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Transactional
    public void deleteEmployeeById(int id) {
        employeeDao.deleteEmployeeById(id);
        employeePositionDao.delEmployeePosition(id);
    }


    public boolean addEmployee(String name, String gender, String path, String phone, String birthday, String startDate, String IDCard,
                               String hometown, String introduce, String types, float salary, String skill, int co) throws ParseException {
        if (birthday == null) return false;
        Date birthdayDate = DateUtils.parseDate(birthday, new String[]{"yyyy-MM-dd"});
        Date startJobDate = DateUtils.parseDate(startDate, new String[]{"yyyy-MM-dd"});

        EmployeeDO employeeDO = EmployeeDO.builder().name(name).gender(Integer.parseInt(gender)).photo(path).salary(salary).skill(skill)
                .startDate(startJobDate).phone(phone).birthday(birthdayDate).idcard(IDCard).hometown(hometown).introduce(introduce).co(co).build();

        boolean result = employeeDao.addEmployee(employeeDO);

        if (result && StringUtils.isNotBlank(types)) {
            List<String> typeList = Splitter.on(",").splitToList(types);
            for (String type : typeList) {
                addEmployeePosition(employeeDO.getId(), Integer.parseInt(type));
            }
        }
        return result;
    }

    public boolean updateEmployee(int id, String name, String gender, String path, String phone, String birthday,
                                  String startDate, String IDCard, String hometown, String introduce, String types, float salary, String skill) throws ParseException {
        if (birthday == null) return false;
        Date birthdayDate = DateUtils.parseDate(birthday, new String[]{"yyyy-MM-dd"});
        Date startJobDate = DateUtils.parseDate(startDate, new String[]{"yyyy-MM-dd"});

        EmployeeDO employeeDO = EmployeeDO.builder().id(id).name(name).gender(Integer.parseInt(gender)).photo(path).skill(skill)
                .phone(phone).birthday(birthdayDate).startDate(startJobDate).idcard(IDCard).hometown(hometown).salary(salary).introduce(introduce).build();

        employeeDao.updateEmployee(employeeDO);

        if (StringUtils.isNotBlank(types)) {
            delEmployeePosition(id);
            List<String> typeList = Splitter.on(",").splitToList(types);
            for (String type : typeList) {
                addEmployeePosition(employeeDO.getId(), Integer.parseInt(type));
            }
        }
        return true;
    }

    public QueryResult<EmployeeDO> getEmployeeList(String name, String phone, int co, String types, int offset, int limit) {
        QueryResult<EmployeeDO> qr = new QueryResult<>();
        List<EmployeeDO> list = employeeDao.getEmployeeList(name, phone, co, types, offset, limit);
        long count = getEmployeeCount(name, phone, co, types);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    private long getEmployeeCount(String name, String phone, int co, String types) {
        return employeeDao.getEmployeeCount(name, phone, co, types);
    }

    private List<EmployeeDO> getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    public String getEmployeeIdJoinByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        Collection<Integer> idList = Collections2.transform(getEmployeeByName(name), input -> input.getId());
        if (CollectionUtils.isEmpty(idList)) {
            return null;
        }

        return Joiner.on(",").join(idList);
    }

    public boolean addEmployeePosition(int employeeId, int position) {
        return employeePositionDao.addEmployeePosition(EmployeePositionDO.builder().employeeId(employeeId).position(position).build());
    }

    public boolean delEmployeePosition(int employeeId) {
        return employeePositionDao.delEmployeePosition(employeeId);
    }

    public long getCountByPosition(int type) {
        return employeePositionDao.getCountByPosition(type);
    }

    public List<Integer> getPositionListByEmployeeId(int employeeId) {
        return employeePositionDao.getPositionListByEmployeeId(employeeId);
    }


}
