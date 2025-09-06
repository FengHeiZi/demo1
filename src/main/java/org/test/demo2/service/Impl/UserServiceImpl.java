package org.test.demo2.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.UserInfo;
import org.test.demo2.mapper.UserMapper;
import org.test.demo2.service.UserService;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        int role = userInfo.getRole();
        if (role == 2){
            int i = userMapper.updateUserInfo(userInfo);
            return i;
        } else  if(role == 1) {
            int i = userMapper.updateUserInfoByAdmin(userInfo);
            return i;
        }
        return 0;
    }



}
