package com.tmall.common;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{ // 用枚举太重，可以使用这种方法
        int ROLE_CUSTOMER = 0;// 普通用户
        int ROLE_ADMIN = 1;// 管理员
    }

}
