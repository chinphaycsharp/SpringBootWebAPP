package com.example.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.course;
import com.example.dto.courseDto;
@Repository
public interface courseRespository extends JpaRepository<courseDto,Long>{
	
}
