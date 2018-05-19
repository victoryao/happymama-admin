package com.happymama.admin.dao;

import com.happymama.admin.model.RecommendDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

/**
 * Created by yaoqiang on 2018/5/13.
 */
public interface RecommendDao {

    @Insert("insert into `recommend`(`order_id`, `price`, `customer_id`, `created`,`updated`) " +
            "values(#{orderId}, #{price}, #{customerId}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    void addRecommend(RecommendDO recommendDO);
}
