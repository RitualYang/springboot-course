package com.wty.mapper;

import com.wty.model.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author RitualYang
 * @create 2019-11-01 17:08
 */
@Transactional
public interface UserMapper {

    User selectOneUser(String username);

}
