package org.test.demo2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.UserPassword;

@Service
public interface UserPasswordService extends IService<UserPassword> {

    UserPassword getUserById(String  id);

    /**
     * 用户登录接口
     *
     * @param username
     * @param password
     */
    int login(String username, String password);

    /**
     * 用户注册接口
     *
     * @param username
     * @param password
     */
    int registered(String username, String password);
}
