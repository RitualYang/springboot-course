package com.wty.service;

import com.wty.model.User;

/**
 * @author wty
 * @date 2019/12/01 16:54
 */
public interface LoginService {
    User getUserByName(String username);
}
