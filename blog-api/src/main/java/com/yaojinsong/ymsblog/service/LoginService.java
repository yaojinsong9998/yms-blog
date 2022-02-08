package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.dao.pojo.SysUser;
import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.params.LoginParam;

public interface LoginService {

    Result login(LoginParam loginParam);

    /**
     * 检查token是否对应user对象
     * @param token
     * @return
     */
    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册
     * @param loginParam
     * @return
     */
    Result register(LoginParam loginParam);
}
