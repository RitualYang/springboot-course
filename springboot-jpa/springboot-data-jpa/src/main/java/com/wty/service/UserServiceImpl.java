package com.wty.service;

import com.wty.dao.UserJpaDao;
import com.wty.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wty
 * @Date 2019/12/19 22:17
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserJpaDao userJpaDao;

    public User getUserByName(String username){
        return userJpaDao.getOne(username);
    }
}
