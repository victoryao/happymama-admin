package com.happymama.admin.dao;

import com.happymama.admin.model.OrderDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/3/31.
 */
public interface OrderDao {

    @Select({"<script>", "select * from `order` where 1=1",
            "<if test='employeeId != 0'> and employee_id = #{employeeId}</if>",
            "<if test='startDate != null'> and (#{startDate} between start_date and end_date</if>",
            "<if test='endDate != null'> or #{endDate} between start_date and end_date) </if>",
            "<if test='endDate = null'> ) </if>",
            "  order by start_date desc limit #{offset},#{limit}", "</script>"})
    public List<OrderDO> getOrders(@Param("employeeId") int employeeId, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("offset") int offset, @Param("limit") int limit);

    @Select({"<script>", "select count(1) from `order` where 1=1",
            "<if test='employeeId != 0'> and employee_id =  #{employeeId}</if>",
            "<if test='startDate != null'> and start_date &gt;=  #{startDate}</if>",
            "<if test='endDate != null'>  and end_date &lt;= #{endDate}</if>",
            "</script>"})
    public long getOrderCount(@Param("employeeId") int employeeId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    @Insert("insert into `order`(`employee_id`,`customer_id`,`price`, `start_date` ,`end_date`,`memo`,`created`,`updated`) " +
            "values(#{employeeId}, #{customerId}, #{price}, #{startDate}, #{endDate},#{memo}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addOrder(OrderDO orderDO);

    @Select("select * from `order` where employee_id = #{eId} and (#{startDate} between  start_date and end_date or #{endDate} between  start_date and end_date) limit 1")
    OrderDO getFirstOrderAvailable(@Param("eId") int eId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    @Delete("delete from `order` where id = #{orderId}")
    void deleteOrderById(@Param("orderId") int orderId);

    @Select("select * from `order` where id = #{id} ")
    OrderDO getOrderById(@Param("id") int id);

    @Update("update `order` set price = #{price} , start_date = #{startDate} , end_date = #{endDate} , memo = #{memo} , updated = now() where id = #{id}")
    void updateOrder(OrderDO orderDO);
}
