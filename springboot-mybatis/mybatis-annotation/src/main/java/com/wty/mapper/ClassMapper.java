package com.wty.mapper;

import com.wty.entity.Class;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface ClassMapper extends Mapper<Class>, MySqlMapper<Class> {
}