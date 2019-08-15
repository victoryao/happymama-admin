package com.happymama.admin.dao;

import com.happymama.admin.model.OrderDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/3/31.
 */
public interface OrderDao {

    @Select({"<script>", "select * from `order` where co=#{co}",
            "<if test='employeeId != 0'> and employee_id = #{employeeId}</if>",
            "<if test='status != -1'> and status = #{status}</if>",
            "<if test='idList != null'> and employee_id in (#{idList}) </if>",
            "<if test='startDate != null'> and start_date &gt;=  #{startDate}</if>",
            "<if test='endDate != null'>  and end_date &lt;= #{endDate}</if>",
//            "<if test='startDate != null'> and (#{startDate} between start_date and end_date</if>",
//            "<if test='startDate != null and endDate == null'> ) </if>",
//            "<if test='endDate != null'> or #{endDate} between start_date and end_date) </if>",
            "  order by id desc limit #{offset},#{limit}", "</script>"})
    public List<OrderDO> getOrders(@Param("employeeId") int employeeId, @Param("startDate") String startDate,
                                   @Param("endDate") String endDate, @Param("idList") String idList,
                                   @Param("status") int status, @Param("co") int co,
                                   @Param("offset") int offset, @Param("limit") int limit);

    @Select({"<script>", "select count(1) from `order` where co=#{co}",
            "<if test='employeeId != 0'> and employee_id =  #{employeeId}</if>",
            "<if test='status != -1'> and status = #{status}</if>",
            "<if test='idList != null'> and employee_id in (#{idList}) </if>",
            "<if test='startDate != null'> and start_date &gt;=  #{startDate}</if>",
            "<if test='endDate != null'>  and end_date &lt;= #{endDate}</if>",
            "</script>"})
    public long getOrderCount(@Param("employeeId") int employeeId, @Param("idList") String idList,
                              @Param("startDate") String startDate, @Param("co") int co, @Param("endDate") String endDate, @Param("status") int status);

    @Insert("insert into `order`(`employee_id`,`customer_id`,`price`, `real_price`, `recommend_price` , `type`, `status`,`start_date` ,`end_date`,`memo`, `co`, `created`,`updated`) " +
            "values(#{employeeId}, #{customerId}, #{price}, #{realPrice}, #{recommendPrice}, #{type}, #{status}, #{startDate}, #{endDate}, #{memo}, #{co}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addOrder(OrderDO orderDO);

    @Select("select * from `order` where employee_id = #{eId} and co = #{co} and (#{startDate} between  start_date and end_date or #{endDate} between  start_date and end_date) limit 1")
    OrderDO getFirstOrderAvailable(@Param("eId") int eId, @Param("co") int co, @Param("startDate") String startDate, @Param("endDate") String endDate);

    @Delete("delete from `order` where id = #{orderId}")
    void deleteOrderById(@Param("orderId") int orderId);

    @Select("select * from `order` where id = #{id} ")
    OrderDO getOrderById(@Param("id") int id);

    @Update("update `order` set price = #{price} , start_date = #{startDate} , end_date = #{endDate} , memo = #{memo} , updated = now() where id = #{id}")
    void updateOrder(OrderDO orderDO);
}
