package com.yaojinsong.ymsblog.controller;

import com.yaojinsong.ymsblog.dao.pojo.SysUser;
import com.yaojinsong.ymsblog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        return Result.success(null);
    }
}
