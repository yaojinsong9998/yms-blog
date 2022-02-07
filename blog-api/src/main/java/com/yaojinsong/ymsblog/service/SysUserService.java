package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.dao.pojo.SysUser;

public interface SysUserService {
    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);
}
