package com.example.demo.responsitory;

import com.example.demo.domain.category;
import com.example.demo.domain.course;
import com.example.demo.dto.categoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface categoryRepository extends JpaRepository<category,Long> {
    @Query("select new com.example.demo.dto.categoryDto(e) from category e")
    List<categoryDto> getAllCourse();

    @Query("select new com.example.demo.dto.categoryDto(e)  from category e where  e.id = :id")
    categoryDto getcategoryById(@Param("id") Long id);

    @Query("select e from category e where  e.id = :id")
    category getById(@Param("id") Long id);

    @Query("select c.id from category c")
    List<Long> getAllIds();
}
