package org.test.demo2.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.UserInfo;
import org.test.demo2.entity.UserPassword;
import org.test.demo2.mapper.UserMapper;
import org.test.demo2.mapper.UserPasswordMapper;
import org.test.demo2.service.UserService;
import org.test.demo2.utils.MD5Utils;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPasswordMapper userPasswordMapper;


    @Override
    public UserInfo getUserById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int login(String username, String password) {
        String passwordMD5 = MD5Utils.MD5Upper(password);
        LambdaQueryWrapper<UserPassword> queryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<UserPassword> wrapper = queryWrapper.eq(UserPassword::getUsername, username);
        UserPassword user = userPasswordMapper.selectOne(wrapper);
        if (user==null){
            return 0;
        }
        if (!user.getPassword().equals(passwordMD5)){
            return 0;
        }
        return 1;
    }
    @Override
    public int registered(String username, String password) {

        LambdaQueryWrapper<UserPassword> queryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<UserPassword> wrapper = queryWrapper.eq(UserPassword::getUsername, username);
        UserPassword user = userPasswordMapper.selectOne(wrapper);
        if (user!=null){
            return 3;
        }else {
            UserPassword userRegister = new UserPassword();
            String passwordMD5 = MD5Utils.MD5Upper(password);
            userRegister.setUsername(username);
            userRegister.setPassword(passwordMD5);
            return userPasswordMapper.insert(userRegister);
        }
    }

}
