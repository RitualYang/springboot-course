package com.wty.service;

import com.wty.model.User;

/**
 * @author wty
 * @create 2019-12-01 16:54
 */
public interface LoginService {
    User getUserByName(String username);
}
