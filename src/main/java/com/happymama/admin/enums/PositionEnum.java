package com.happymama.admin.enums;

/**
 * Created by yaoqiang on 2018/3/20.
 */
public enum PositionEnum {

    STUDENT(0), //学员
    BABYSITTER(1), //月嫂
    TEACHER(2), //讲师
    YUERSAO(3); //育儿嫂

    private int val;

    PositionEnum(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
