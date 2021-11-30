package com.example.demo.service;

import com.example.demo.dto.user_courseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userCourseService {
    user_courseDto saveOrUpdate (Long Id, user_courseDto dto);

    List<user_courseDto> getUserRegisterCourse(Long id_user,Long id_course);
}
