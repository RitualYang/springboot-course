package com.wty.mapper;
import com.wty.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorMapper extends JpaRepository<Major,String> {
}