package org.test.demo2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.UserInfo;

@Service
public interface UserService extends IService<UserInfo> {

    int updateUserInfo(UserInfo userInfo);

}
