package com.happymama.admin.dao;

import com.happymama.admin.model.EmployeeDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yaoqiang on 2018/3/18.
 */
public interface EmployeeDao {

    @Insert("insert into employee(`name`,`gender`,`phone`,`birthday`,`idcard`,`hometown`,`introduce`,`created`,`updated`) " +
            "values(#{name},#{gender},#{phone},#{birthday},#{idcard},#{hometown},#{introduce}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    public boolean addEmployee(EmployeeDO employeeDO);


    @Select("select * from employee limit #{offset},#{limit}")
    public List<EmployeeDO> getEmployeeList(@Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(1) from employee")
    public long getEmployeeCount();


}
