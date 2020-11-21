package com.wty.mapper;

import com.wty.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper extends JpaRepository<Student, String> {
}