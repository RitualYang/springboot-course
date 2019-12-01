package com.wty.mapper;

import com.wty.model.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author RitualYang
 * @create 2019-11-01 17:08
 */
public interface UserMapper extends Mapper<User> {

    @Select("SELECT * FROM user WHERE username = #{username}")
    public User selcetOneUser(String username);

}
