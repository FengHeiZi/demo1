package org.test.demo2.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.UserPassword;
import org.test.demo2.mapper.UserPasswordMapper;
import org.test.demo2.service.UserPasswordService;
import org.test.demo2.utils.MD5Utils;

@Service
public class UserPasswordImpl extends ServiceImpl<UserPasswordMapper, UserPassword> implements UserPasswordService {


    @Autowired
    private UserPasswordMapper userPasswordMapper;

    @Override
    public UserPassword getUserById(String id) {
        return baseMapper.selectById(id);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
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

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
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
