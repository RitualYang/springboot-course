package com.ritualyang.mapper;

import com.ritualyang.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author RitualYang
 * @create 2019-11-01 17:08
 */
@Transactional
public interface UserMapper {

    User selectOneUser(String username);

}
