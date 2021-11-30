package com.example.demo.rest;


import com.example.demo.domain.category;
import com.example.demo.dto.categoryDto;
import com.example.demo.responsitory.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/category")
public class restCategoryController {
    @Autowired
    EntityManager entity;

    @Autowired
    categoryRepository respository;

    @Autowired
    com.example.demo.service.categoryService categoryService;

    @GetMapping(value = "/test")
    public String test()
    {
        return "hello world";
    }


    @GetMapping(value = "")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<categoryDto> getAll()
    {
        List<categoryDto> l = respository.getAllCourse();
        return l;
    }

    @GetMapping(value = "/allids")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Long> getAllIds()
    {
        List<Long> l = respository.getAllIds();
        return l;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}")
    public categoryDto getCategory(@PathVariable String id)
    {
        categoryDto dto = respository.getcategoryById(new Long(id));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public categoryDto saveOrUpdate(@PathVariable String id, @RequestBody categoryDto categoryDto)
    {
        categoryDto dto = categoryService.saveOrUpdate(new Long(id), categoryDto);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public categoryDto deleteForever(@PathVariable String id)
    {
        category c = respository.getById(new Long(id));
        categoryDto dto = new categoryDto(c);
        respository.delete(c);
        return dto;
    }
}
