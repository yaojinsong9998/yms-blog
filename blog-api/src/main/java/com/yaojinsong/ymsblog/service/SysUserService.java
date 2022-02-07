package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.dao.pojo.SysUser;
import com.yaojinsong.ymsblog.vo.Result;

public interface SysUserService {
    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);
}
