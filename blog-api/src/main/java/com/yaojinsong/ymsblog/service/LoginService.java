package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.dao.pojo.SysUser;
import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.params.LoginParam;

public interface LoginService {

    Result login(LoginParam loginParam);

    SysUser chekToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);
}
