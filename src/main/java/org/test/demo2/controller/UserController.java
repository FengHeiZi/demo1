package org.test.demo2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.demo2.entity.UserInfo;
import org.test.demo2.service.UserService;
import org.test.demo2.utils.R;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/updateInfo")
    public R updateInfo(@RequestBody UserInfo userInfo) {
        log.info("修改用户信息--{}", userInfo);
        int i = userService.updateUserInfo(userInfo);
        if (i == 0){
            return R.error();
        }
        return R.ok();
    }
}
