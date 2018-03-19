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


    @Select({"<script>", "select * from employee where 1=1  ",
            "<if test='name != null'> and name = #{name}</if>",
            "<if test='phone != null'> and phone = #{phone}</if> ",
            "<if test='types != null'> and id in (select employee_id from employee_position where position in (#{types}))</if> ",
            "limit #{offset},#{limit}", "</script>"})
    public List<EmployeeDO> getEmployeeList(@Param("name") String name, @Param("phone") String phone, @Param("types") String types, @Param("offset") int offset, @Param("limit") int limit);

    @Select({"<script>", "select count(1) from employee where 1=1 ",
            "<if test='name != null'> and name = #{name}</if>",
            "<if test='phone != null'> and phone = #{phone}</if> ",
            "<if test='types != null'> and id in (select employee_id from employee_position where position in (#{types}))</if> ",
            "</script>"})
    public long getEmployeeCount(@Param("name") String name, @Param("phone") String phone, @Param("types") String types);

}
