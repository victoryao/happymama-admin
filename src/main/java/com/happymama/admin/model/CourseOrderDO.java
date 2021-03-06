package com.happymama.admin.model;

import lombok.*;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/5/19.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseOrderDO {
    private int id;
    private int employeeId;
    private Date achieveDate;
    private int achieveType;
    private float price;
    private float realPrice;
    private float recommendPrice;
    private int courseId;
    private int customerId;
    private String courseName;
    private String recommendName;
    private String recommendPhone;

}
