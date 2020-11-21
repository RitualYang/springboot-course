package com.wty.mapper;

import com.wty.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper extends JpaRepository<Class, String> {
}