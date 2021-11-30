package com.example.demo.service;

import com.example.demo.dto.courseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface courseService {

    courseDto saveOrUpdate (Long Id, courseDto dto);

    List<courseDto> getCourseManyUser();

    List<courseDto> getCourseByName(String name);
}
