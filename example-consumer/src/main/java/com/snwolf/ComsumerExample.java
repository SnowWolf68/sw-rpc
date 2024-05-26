package com.snwolf;

import com.snwolf.model.User;
import com.snwolf.proxy.ServiceProxyFactory;
import com.snwolf.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComsumerExample {

    public static void main(String[] args) {
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("snwolf");
        User newUser = userService.getUser(user);
        if(newUser != null){
            log.info("username: " + user.getName());
        }else{
            log.info("user not found");
        }
        UserService mockProxy = ServiceProxyFactory.getMockProxy(UserService.class);
        short number = mockProxy.getNumber();
        log.info(number + "");
    }
}
