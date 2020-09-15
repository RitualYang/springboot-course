package com.wty.mapper;

import com.wty.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonMapper extends JpaRepository<Lesson,String> {
}