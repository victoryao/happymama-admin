package com.happymama.admin.dao;

import com.happymama.admin.model.CustomerDO;
import org.apache.ibatis.annotations.*;

/**
 * Created by yaoqiang on 2018/3/31.
 */
public interface CustomerDao {

    @Insert("insert into `customer`(`name`,`phone`,`address`, `created`,`updated`) " +
            "values(#{name}, #{phone}, #{address}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addCustomer(CustomerDO customerDO);

    @Select("select * from `customer` where id = #{customerId}")
    CustomerDO getCustomerById(@Param("customerId") int customerId);

    @Select("select * from `customer` where phone = #{phone}")
    CustomerDO getCustomerByPhone(@Param("phone") String phone);

    @Update("update `customer` set `name` = #{name}, phone = #{phone}, address = #{address}, `updated` = now() where id = #{id}")
    void updateCustomer(CustomerDO customerDO);
}
