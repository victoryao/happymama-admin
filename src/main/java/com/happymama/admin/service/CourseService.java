package com.happymama.admin.service;

import com.happymama.admin.dao.CourseDao;
import com.happymama.admin.model.CourseDO;
import com.happymama.admin.model.CourseOrderDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/5/15.
 */
@Service
public class CourseService {

    @Resource
    private CourseDao courseDao;

    public boolean addCourse(CourseOrderDO courseOrderDO) {
        return courseDao.addCourse(courseOrderDO);
    }

    public boolean delCourseOrder(int orderId) {
        return courseDao.delCourseOrder(orderId);
    }

    public CourseDO getCourseById(int id) {
        return courseDao.getCourseById(id);
    }

    public List<CourseDO> getCourseList() {
        return courseDao.getCourseList();
    }

    public List<CourseOrderDO> getCourseOrderListByEmployeeId(int employeeId) {
        return courseDao.getCourseOrderListByEmployeeId(employeeId);
    }

}
