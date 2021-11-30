package com.example.demo.rest;

import com.example.demo.domain.information;
import com.example.demo.dto.informationDto;
import com.example.demo.responsitory.informationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/information")
public class restInformationController {

    @Autowired
    EntityManager entity;

    @Autowired
    informationRepository respository;

    @Autowired
    com.example.demo.service.informationService informationService;

    @GetMapping(value = "/test")
    public String test()
    {
        return "hello world";
    }


    @GetMapping(value = "")
    public List<informationDto> getAll()
    {
        List<informationDto> l = respository.getAllCourse();
        return l;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}")
    public informationDto getInformation(@PathVariable String id)
    {
        informationDto dto = respository.getInformationById(new Long(id));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "getinformationbyiduser/{id_user}")
    public informationDto getInformationByIdUser(@PathVariable String id_user)
    {
        informationDto dto = respository.getInformationByIdUser(new Long(id_user));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public informationDto saveOrUpdate(@PathVariable String id, @RequestBody informationDto courseDto)
    {
        informationDto dto = informationService.saveOrUpdate(new Long(id), courseDto);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public informationDto deleteForever(@PathVariable String id)
    {
        information c = respository.getById(new Long(id));
        informationDto dto = new informationDto(c);
        respository.delete(c);
        return dto;
    }

}
