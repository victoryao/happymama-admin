package com.happymama.admin.dao;

import com.happymama.admin.model.AdminDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yaoqiang on 2018/3/18.
 */
public interface AdminDao {

    @Select("select * from admin where name = #{name} and password = #{password}")
    public AdminDO login(@Param("name") String name, @Param("password") String password);

}
