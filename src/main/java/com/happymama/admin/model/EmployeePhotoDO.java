package com.happymama.admin.model;

import lombok.*;

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
public class EmployeePhotoDO {

    private int id;
    private int employeeId;
    private String img;
    private int type;
    private Date created;
}
