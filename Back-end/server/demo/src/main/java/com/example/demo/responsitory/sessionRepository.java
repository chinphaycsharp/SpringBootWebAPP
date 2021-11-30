package com.example.demo.responsitory;

import com.example.demo.domain.course;
import com.example.demo.domain.session;
import com.example.demo.dto.informationDto;
import com.example.demo.dto.sessionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface sessionRepository extends JpaRepository<session,Long> {
    @Query("select new com.example.demo.dto.sessionDto(e) from session e")
    List<sessionDto> getAllCourse();

    @Query("select new com.example.demo.dto.sessionDto(e)  from session e where  e.id = :id")
    sessionDto getInformationById(@Param("id") Long id);

    @Query("select e from session e where  e.id = :id")
    session getById(@Param("id") Long id);

    @Query("select new com.example.demo.dto.sessionDto(s) from session s where s.id_course = :id_course")
    List<sessionDto> getSessionByIdCourse(@Param("id_course") Long id_course);
}
