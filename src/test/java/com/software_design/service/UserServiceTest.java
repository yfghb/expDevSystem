package com.software_design.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void selectByAct(){
//        String md5 = DigestUtils.md5DigestAsHex("123456123456".getBytes());
//        System.out.println(md5);
        System.out.println(userService.selectByAct("123456"));
    }
}
