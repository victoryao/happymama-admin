package com.happymama.admin.dao;

import com.happymama.admin.model.CourseDO;
import com.happymama.admin.model.CourseOrderDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/5/15.
 */
public interface CourseDao {

    @Select("select * from `course`")
    List<CourseDO> getCourseList();

    @Insert("insert into `course_order`(`employee_id`, `price`, `real_price`, `recommend_price`, `course_id`,`customer_id`, `created`,`updated`) " +
            "values(#{employeeId}, #{price}, #{realPrice}, #{recommendPrice}, #{courseId}, #{customerId}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addCourse(CourseOrderDO courseOrderDO);


    @Select("select * from `course_order` where employee_id = #{employeeId}")
    List<CourseOrderDO> getCourseOrderListByEmployeeId(@Param("employeeId") int employeeId);

    @Select("select * from `course` where id = #{id}")
    CourseDO getCourseById(@Param("id") int id);

    @Delete("delete from `course_order` where id = #{id}")
    boolean delCourseOrder(int id);
}
