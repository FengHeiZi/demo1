package org.test.demo2.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.test.demo2.service.UserService;
import org.test.demo2.utils.R;

@RestController
@RequestMapping("/auth")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestParam String username, @RequestParam String password) {
        int login = userService.login(username, password);
        if (login==0){
            return R.error().message("登陆失败");
        }
        return R.ok().message("登陆成功");
    }

    @PostMapping("/registered")
    public R registered(@RequestParam String username, @RequestParam String password){
        int registered = userService.registered(username, password);
        if (registered==0){
            return R.error().message("注册失败");
        } else if (registered==3) {
            return R.error().message("用户已存在");
        }
        return R.ok().message("注册成功");
    }
}
