package com.happymama.admin.model;

import lombok.*;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminDO {

    private String name;
    private String password;
    private int co;
}
