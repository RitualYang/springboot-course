package com.wty.mapper;

import com.wty.entity.Instruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructMapper extends JpaRepository<Instruct, String> {
}