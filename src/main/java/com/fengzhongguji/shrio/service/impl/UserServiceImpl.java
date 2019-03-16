package com.fengzhongguji.shrio.service.impl;

import com.fengzhongguji.shrio.dao.UserMapper;
import com.fengzhongguji.shrio.domain.User;
import com.fengzhongguji.shrio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }
}
