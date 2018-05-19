package com.happymama.admin.model;

import lombok.*;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDO {
    private int id;
    private int employeeId;
    private String employeeName;
    private int customerId;
    private String customerName;
    private String customerPhone;
    private float price;
    private float realPrice;
    private float recommendPrice;
    private Date startDate;
    private Date endDate;
    private String memo;
    private Date created;
    private Date updated;
}
