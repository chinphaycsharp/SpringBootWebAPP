package com.example.demo.rest;


import com.example.demo.dto.messageDto;
import com.example.demo.responsitory.messageRepository;
import com.example.demo.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/message")
public class restMessageController {
    @Autowired
    EntityManager entity;

    @Autowired
    messageService service;

    @Autowired
    messageRepository repository;

    @GetMapping(value = "")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<messageDto> getAll()
    {
        List<messageDto> l = repository.getAllMessage();
        return l;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public messageDto saveOrUpdate(@PathVariable String id, @RequestBody messageDto messageDto)
    {
        messageDto dto = service.saveOrUpdate(new Long(id), messageDto);
        return dto;
    }
}
