package com.wty.mapper;

import com.wty.entity.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface StudentMapper extends Mapper<Student>, MySqlMapper<Student> {
}