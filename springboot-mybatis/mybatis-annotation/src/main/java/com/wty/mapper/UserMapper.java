package com.wty.mapper;

import com.wty.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wty
 * @Date 2019/11/01 17:08
 */
@Component
public interface UserMapper extends Mapper<User> {

    @Select("SELECT * FROM user WHERE username = #{username}")
    public User selcetOneUser(String username);

    /**
     * 查询用户
     * @return
     */
    @Select("select * from user  where uid=#{uid}")
    @Results(id="userMap",value={
            @Result(id=true,column = "uid",property = "uid"),
            @Result(column = "username",property = "userName"),
            @Result(property = "userInfos",column = "uid",
                    many = @Many(select = "com.wty.mapper.UserInfoMapper.findAllByUid",
                            fetchType = FetchType.LAZY))
    })// fetchType:开启延时加载。LAZY：延时加载。EAGER：立即加载。DEFAULT：默认。
    User findOne(Integer uid);

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    @Select("select * from user  where uid=#{uid}")
    User findById(Integer uid);

}
