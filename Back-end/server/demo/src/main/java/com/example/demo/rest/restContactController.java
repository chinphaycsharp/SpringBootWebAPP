package com.example.demo.rest;

import com.example.demo.domain.category;
import com.example.demo.domain.contact;
import com.example.demo.dto.categoryDto;
import com.example.demo.dto.contactDto;
import com.example.demo.dto.courseDto;
import com.example.demo.responsitory.contactRepository;
import com.example.demo.service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/contact")
public class restContactController {
    @Autowired
    EntityManager entity;

    @Autowired
    contactRepository respository;

    @Autowired
    com.example.demo.service.contactService contactService;

    @GetMapping(value = "/test")
    public String test()
    {
        return "hello world";
    }


    @GetMapping(value = "")
    public List<contactDto> getAll()
    {
        List<contactDto> l = respository.getAllCourse();
        return l;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}")
    public contactDto getContact(@PathVariable String id)
    {
        contactDto dto = respository.getContactById(new Long(id));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public contactDto saveOrUpdate(@PathVariable String id, @RequestBody contactDto contactDto)
    {
        contactDto dto = contactService.saveOrUpdate(new Long(id), contactDto);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public contactDto deleteForever(@PathVariable String id)
    {
        contact c = respository.getById(new Long(id));
        contactDto dto = new contactDto(c);
        respository.delete(c);
        return dto;
    }
}
