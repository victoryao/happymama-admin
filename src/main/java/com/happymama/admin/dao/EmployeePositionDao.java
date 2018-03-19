package com.happymama.admin.dao;

import com.happymama.admin.model.EmployeePositionDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

/**
 * Created by yaoqiang on 2018/3/18.
 */
public interface EmployeePositionDao {

    @Insert("insert into employee_position(`employee_id`,`position`,`created`,`updated`) " +
            "values(#{employeeId}, #{position}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    public boolean addEmployeePosition(EmployeePositionDO employeePositionDO);

    @Select("select count(1) from employee_position where position = #{type}")
    public long getCountByPosition(@Param("type") int type);

}
