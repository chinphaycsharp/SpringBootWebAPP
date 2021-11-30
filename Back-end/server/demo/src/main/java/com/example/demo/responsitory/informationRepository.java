package com.example.demo.responsitory;

import com.example.demo.domain.information;
import com.example.demo.dto.courseDto;
import com.example.demo.dto.informationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface informationRepository extends JpaRepository<information,Long> {
    @Query("select new com.example.demo.dto.informationDto(e) from information e")
    List<informationDto> getAllCourse();

    @Query("select new com.example.demo.dto.informationDto(e)  from information e where  e.id = :id")
    informationDto getInformationById(@Param("id") Long id);

    @Query("select e from information e where  e.id = :id")
    information getById(@Param("id") Long id);

    @Query("select new com.example.demo.dto.informationDto(e)  from information e where  e.id_user = :id_user")
    informationDto getInformationByIdUser(@Param("id_user") Long id_user);
}
