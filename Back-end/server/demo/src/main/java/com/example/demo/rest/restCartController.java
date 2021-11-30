package com.example.demo.rest;

import com.example.demo.domain.cart;
import com.example.demo.dto.cartDto;
import com.example.demo.responsitory.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/cart")
public class restCartController {

    @Autowired
    EntityManager entity;

    @Autowired
    cartRepository respository;

    @Autowired
    com.example.demo.service.cartService cartService;

    @GetMapping(value = "")
    public List<cartDto> getAll()
    {
        List<cartDto> l = respository.getAll();
        return l;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}")
    public cartDto getCart(@PathVariable String id)
    {
        cartDto dto = respository.getcategoryById(new Long(id));
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}")
    public cartDto saveOrUpdate(@PathVariable String id, @RequestBody cartDto categoryDto)
    {
        cartDto dto = cartService.saveOrUpdate(new Long(id), categoryDto);
        return dto;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public cartDto deleteForever(@PathVariable String id)
    {
        cart c = respository.getById(new Long(id));
        cartDto dto = new cartDto(c);
        respository.delete(c);
        return dto;
    }
}
