package com.example.demo.rest;

import com.example.demo.domain.session;
import com.example.demo.dto.sessionDto;
import com.example.demo.responsitory.sessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/session")
public class restSessionController {
    @Autowired
    EntityManager entity;

    @Autowired
    sessionRepository respository;

    @Autowired
    com.example.demo.service.sessionService sessionService;

    @GetMapping(value = "/test")
    public String test()
    {
        return "hello world";
    }


    @GetMapping(value = "")
    public List<sessionDto> getAll()
    {
        List<sessionDto> l = respository.getAllCourse();
        return l;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}")
    public sessionDto getSession(@PathVariable String id)
    {
        sessionDto dto = respository.getInformationById(new Long(id));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "getsessionbyiduser/{id_course}")
    public List<sessionDto> getSessionByIdCourse(@PathVariable String id_course)
    {
        List<sessionDto> dto = respository.getSessionByIdCourse(new Long(id_course));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public sessionDto saveOrUpdate(@PathVariable String id, @RequestBody sessionDto courseDto)
    {
        sessionDto dto = sessionService.saveOrUpdate(new Long(id), courseDto);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public sessionDto deleteForever(@PathVariable String id)
    {
        session c = respository.getById(new Long(id));
        sessionDto dto = new sessionDto(c);
        respository.delete(c);
        return dto;
    }


}
