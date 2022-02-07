package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.params.LoginParam;

public interface LoginService {

    Result login(LoginParam loginParam);
}
