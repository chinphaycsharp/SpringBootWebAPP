package com.example.demo.responsitory;

import com.example.demo.domain.user_course;
import com.example.demo.dto.user_courseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userCourseRespository extends JpaRepository<user_course,Long> {
    @Query("select new com.example.demo.dto.user_courseDto(e) from user_course e")
    List<user_courseDto> getAll();

    @Query("select e from user_course e where  e.id = :id")
    user_course getById(@Param("id") Long id);

    @Query("select new com.example.demo.dto.user_courseDto(e) from user_course e where  e.id = :id")
    user_courseDto getCourseById(@Param("id") Long id);

    @Query("select new com.example.demo.dto.user_courseDto(e) from user_course e where  e.id_user = :id_user")
    List<user_courseDto> getCourseByIdUser(@Param("id_user") Long id_user);
}
