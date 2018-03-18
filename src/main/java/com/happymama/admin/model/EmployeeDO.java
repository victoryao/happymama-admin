package com.happymama.admin.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDO {

    private int id;
    private String name;
    private int gender;
    private String phone;
    private Date birthday;
    private String idcard;
    private String hometown;
    private String introduce;
    private Date created;
    private Date updated;
}
