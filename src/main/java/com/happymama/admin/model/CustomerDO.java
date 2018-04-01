package com.happymama.admin.model;

import lombok.*;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDO {
    private int id;
    private String name;
    private String phone;
    private String address;
}
