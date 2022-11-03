package com.software_design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software_design.dao.UserMapper;
import com.software_design.entity.User;
import com.software_design.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByAct(String account) {
        return userMapper.selectByAct(account);
    }
}
