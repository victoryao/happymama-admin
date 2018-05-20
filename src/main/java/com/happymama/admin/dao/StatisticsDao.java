package com.happymama.admin.dao;

import org.apache.ibatis.annotations.Select;

/**
 * Created by yaoqiang on 2018/5/19.
 */
public interface StatisticsDao {

    @Select("select sum(real_price) from course_order")
    public Integer getCourseInput();

    @Select("select sum(real_price) from `order`")
    public Integer getOrderInput();
}
