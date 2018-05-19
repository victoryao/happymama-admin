package com.happymama.admin.model;

import lombok.*;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/5/13.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendDO {
    private int id;
    private int orderId;
    private float price;
    private int customerId;
    private Date created;
    private Date updated;
}
