package com.example.demo.rest;

import com.example.demo.domain.type;
import com.example.demo.dto.typeDto;
import com.example.demo.responsitory.typeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/type")
public class restTypeController {

    @Autowired
    EntityManager entity;

    @Autowired
    typeRepository respository;

    @Autowired
    com.example.demo.service.typeService typeService;

    @GetMapping(value = "/test")
    public String test()
    {
        return "hello world";
    }


    @GetMapping(value = "")
    public List<typeDto> getAll()
    {
        List<typeDto> l = respository.getAllCourse();
        return l;
    }

    @GetMapping(value = "/allids")
    public List<Long> getAllIds()
    {
        List<Long> l = respository.getAllIds();
        return l;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}")
    public typeDto getType(@PathVariable String id)
    {
        typeDto dto = respository.getTypeById(new Long(id));
        return dto;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public typeDto deleteType(@PathVariable String id, @RequestBody typeDto courseDto)
    {
        typeDto dto = typeService.saveOrUpdate(new Long(id), courseDto);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public typeDto deleteForever(@PathVariable String id)
    {
        type c = respository.getById(new Long(id));
        typeDto dto = new typeDto(c);
        respository.delete(c);
        return dto;
    }
}
