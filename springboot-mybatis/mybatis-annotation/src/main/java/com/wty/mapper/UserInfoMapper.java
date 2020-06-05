package com.wty.mapper;

import com.wty.model.UserInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wty
 * @create 2020-01-04 23:17
 */
@Component
public interface UserInfoMapper extends Mapper<UserInfo> {

    /**
     * 查询所有用户信息及用户
     * @return
     */
    @Select("select * from userinfo")
    @Results(id="userInfoMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(property = "user",column = "uid",one=@One(select="com.wty.mapper.UserMapper.findById",fetchType= FetchType.EAGER))
    })
    List<UserInfo> findAll();

    /**
     * 根据用户id查询用户信息
     * @param uid
     * @return
     */
    @Select("select * from userinfo where uid = #{uid}")
    List<UserInfo> findAllByUid(Integer uid);
}
