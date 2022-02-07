package com.yaojinsong.ymsblog.service.impl;

import com.alibaba.fastjson.JSON;
import com.yaojinsong.ymsblog.dao.pojo.SysUser;
import com.yaojinsong.ymsblog.service.LoginService;
import com.yaojinsong.ymsblog.service.SysUserService;
import com.yaojinsong.ymsblog.utils.JWTUtils;
import com.yaojinsong.ymsblog.vo.ErrorCode;
import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.params.LoginParam;
import io.netty.util.internal.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginServiceImpl implements LoginService {

    //加密盐
    private static final String slat = "mszlu!@#";

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public Result login(LoginParam loginParam) {
        /**
         * 1.检查参数是否合法
         * 2.根据用户名和密码去user表中查询 是否存在
         * 3.若果不存在 登录失败
         * 4.如果存在 使用jwt生成Token返回给前端
         * 5.token放入redis中 token:user信息 设置过期时间
         * （登录认证的时候，先认证token字符串是否合法 去redis认证是否存在）
         */
        String password = loginParam.getPassword();
        String account = loginParam.getAccount();
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        //加密
        password = DigestUtils.md5Hex(password + slat);
        SysUser sysUser = sysUserService.findUser(account,password);
        if(sysUser == null){
            return Result.fail(ErrorCode.ACCOUNT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);
        return Result.success(token);
    }

    @Override
    public SysUser chekToken(String token) {
        if(StringUtils.isBlank(token)){
            return null;
        }
        Map<String, Object> map = JWTUtils.checkToken(token);
        if(map == null){
            return null;
        }
        String userJson = redisTemplate.opsForValue().get("TOKEN_" + token);
        if(StringUtils.isBlank(userJson)){
            return null;
        }
        //解析成user对象
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);
        return sysUser;
    }
}
