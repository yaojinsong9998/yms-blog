package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.dao.pojo.SysUser;
import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.UserVo;

public interface SysUserService {
    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);

    /**
     * 根据账户获取用户信息
     * @param account
     * @return
     */
    SysUser findUserByAccount(String account);

    /**
     * 保存用户
     * @param sysUser
     */
    void save(SysUser sysUser);
}
