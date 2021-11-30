package com.example.demo.responsitory;

import com.example.demo.domain.course;
import com.example.demo.domain.type;
import com.example.demo.dto.sessionDto;
import com.example.demo.dto.typeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface typeRepository extends JpaRepository<type,Long> {

    @Query("select new com.example.demo.dto.typeDto(e) from type e")
    List<typeDto> getAllCourse();

    @Query("select new com.example.demo.dto.typeDto(e)  from type e where  e.id = :id")
    typeDto getTypeById(@Param("id") Long id);

    @Query("select e from type e where  e.id = :id")
    type getById(@Param("id") Long id);

    @Query("select t.id from type t")
    List<Long> getAllIds();
}
