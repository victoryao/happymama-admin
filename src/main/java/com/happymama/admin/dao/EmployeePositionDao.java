package com.happymama.admin.dao;

import com.happymama.admin.model.EmployeePositionDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/3/18.
 */
public interface EmployeePositionDao {

    @Insert("insert into employee_position(`employee_id`,`position`,`created`,`updated`) " +
            "values(#{employeeId}, #{position}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    public boolean addEmployeePosition(EmployeePositionDO employeePositionDO);

    @Delete("delete from employee_position where employee_id = #{id}")
    public boolean delEmployeePosition(int id);


    @Select("select count(1) from employee_position where position = #{type}")
    public long getCountByPosition(@Param("type") int type);

    @Select("select position from employee_position where employee_id = #{employeeId}")
    public List<Integer> getPositionListByEmployeeId(@Param("employeeId") int employeeId);

}
