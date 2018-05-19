package com.happymama.admin.model;

import lombok.*;

/**
 * Created by yaoqiang on 2018/5/15.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDO {
    private int id;
    private String name;
    private float price;
    private String content;
}
