package com.wty.dao;

import com.wty.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wty
 * @Date 2019/12/19 22:16
 */
public interface UserJpaDao extends JpaRepository<User,String> {

}
