package com.snwolf.service;

import com.snwolf.model.User;

public interface UserService {

    User getUser(User user);

    /**
     * 用于测试 mock 接口返回值
     *
     * @return
     */
    default short getNumber() {
        return 1;
    }
}
