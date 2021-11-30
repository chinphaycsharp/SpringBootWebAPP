package com.example.demo.rest;

import com.example.demo.domain.user_course;
import com.example.demo.dto.courseDto;
import com.example.demo.dto.user_courseDto;
import com.example.demo.responsitory.userCourseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/usercourse")
public class restUserCourseController {

    @Autowired
    EntityManager entity;

    @Autowired
    userCourseRespository respository;

    @Autowired
    com.example.demo.service.userCourseService service;

    @GetMapping(value = "/all")
    public List<user_courseDto> getAll()
    {
        List<user_courseDto> l = respository.getAll();
        return l;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}")
    public user_courseDto getUser(@PathVariable String id)
    {
        user_courseDto dto = respository.getCourseById(new Long(id));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public user_courseDto saveOrUpdate(@PathVariable String id, @RequestBody user_courseDto user_courseDto)
    {
        user_courseDto dto = service.saveOrUpdate(new Long(id), user_courseDto);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "getbyuser/{id_user}")
    public List<user_courseDto> getCourseByIdUser(@PathVariable String id_user)
    {
        List<user_courseDto> dto = respository.getCourseByIdUser(new Long(id_user));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public user_courseDto deleteForever(@PathVariable String id)
    {
        user_course c = respository.getById(new Long(id));
        user_courseDto dto = new user_courseDto(c);
        respository.delete(c);
        return dto;
    }
}
