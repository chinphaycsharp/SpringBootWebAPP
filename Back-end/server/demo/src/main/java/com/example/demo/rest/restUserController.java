package com.example.demo.rest;


import com.example.demo.domain.user;
import com.example.demo.dto.userDto;
import com.example.demo.responsitory.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/user")
public class restUserController {
    @Autowired
    EntityManager entity;

    @Autowired
    userRepository respository;

    @Autowired
    com.example.demo.service.userService userService;

    @GetMapping(value = "/test")
    public String test()
    {
        return "hello world";
    }


    @GetMapping(value = "/all")
    public List<userDto> getAll()
    {
        List<userDto> l = respository.getAll();
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
    public userDto getUser(@PathVariable String id)
    {
        userDto dto = respository.getUserById(new Long(id));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "")
    public userDto getUserUserName(@RequestParam(value = "username") String username)
    {
        userDto dto = respository.getUserByUserName(username);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public userDto saveOrUpdate(@PathVariable String id, @RequestBody userDto courseDto)
    {
        userDto dto = userService.saveOrUpdate(new Long(id), courseDto);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public userDto deleteForever(@PathVariable String id)
    {
        user c = respository.getById(new Long(id));
        userDto dto = new userDto(c);
        respository.delete(c);
        return dto;
    }
}
