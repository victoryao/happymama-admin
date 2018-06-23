package com.happymama.admin.model;

import lombok.*;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/6/22.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeDO {

    private int id;
    private String title;
    private String content;
    private String img;
    private int type;
    private Date created;
    private Date updated;

}
