package com.wty.mapper;

import com.wty.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherMapper extends JpaRepository<Teacher, String> {
}