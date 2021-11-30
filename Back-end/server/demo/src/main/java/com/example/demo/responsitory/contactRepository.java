package com.example.demo.responsitory;

import com.example.demo.domain.contact;
import com.example.demo.dto.categoryDto;
import com.example.demo.dto.contactDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface contactRepository extends JpaRepository<contact,Long> {
    @Query("select new com.example.demo.dto.contactDto(e) from contact e")
    List<contactDto> getAllCourse();

    @Query("select new com.example.demo.dto.contactDto(e)  from contact e where  e.id = :id")
    contactDto getContactById(@Param("id") Long id);

    @Query("select e from contact e where  e.id = :id")
    contact getById(@Param("id") Long id);
}
