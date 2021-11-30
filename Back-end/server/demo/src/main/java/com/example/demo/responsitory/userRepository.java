package com.example.demo.responsitory;

import com.example.demo.domain.course;
import com.example.demo.domain.type;
import com.example.demo.domain.user;
import com.example.demo.dto.typeDto;
import com.example.demo.dto.userDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userRepository extends JpaRepository<user,Long> {
    @Query("select new com.example.demo.dto.userDto(e) from user e")
    List<userDto> getAll();

    @Query("select e from user e where  e.id = :id")
    user getById(@Param("id") Long id);

    @Query("select new com.example.demo.dto.userDto(e) from user e where  e.id = :id")
    userDto getUserById(@Param("id") Long id);

    @Query("select new com.example.demo.dto.userDto(e) from user e where  e.username = :username")
    userDto getUserByUserName(@Param("username") String username);

    @Query("select u.id from user u")
    List<Long> getAllIds();
}
