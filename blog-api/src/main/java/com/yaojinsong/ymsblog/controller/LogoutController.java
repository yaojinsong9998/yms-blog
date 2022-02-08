package com.yaojinsong.ymsblog.controller;

import com.yaojinsong.ymsblog.service.LoginService;
import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("logout")
public class LogoutController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public Result logout(@RequestHeader("Authorization") String token){
        //退出登录
        return loginService.logout(token);
    }
}
