package org.test.demo2.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.UserPassword;
import org.test.demo2.mapper.UserPasswordMapper;
import org.test.demo2.service.UserPasswordService;

@Service
public class UserPasswordImpl extends ServiceImpl<UserPasswordMapper, UserPassword> implements UserPasswordService {
}
