package com.example.demo.responsitory;

import com.example.demo.dto.categoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.course;
import com.example.demo.dto.courseDto;

import java.util.List;

@Repository
public interface courseRespository extends JpaRepository<course,Long>{

    @Query("select new com.example.demo.dto.courseDto(e) from course e")
    List<courseDto> getAllCourse();

    @Query("select new com.example.demo.dto.courseDto(e)  from course e where  e.id = :id")
    courseDto getCourseById(@Param("id") Long id);

    @Query("select e from course e where  e.id = :id")
    course getById(@Param("id") Long id);

    @Query("select new com.example.demo.dto.courseDto(e) from course e where  e.id_user = :id_user")
    List<courseDto> getCourseByIdUser(@Param("id_user") Long id_user);
}
