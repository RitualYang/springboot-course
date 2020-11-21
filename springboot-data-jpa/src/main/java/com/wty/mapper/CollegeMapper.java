package com.wty.mapper;

import com.wty.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeMapper extends JpaRepository<College, String> {
}