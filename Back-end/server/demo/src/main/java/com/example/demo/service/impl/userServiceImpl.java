package com.example.demo.service.impl;
import com.example.demo.domain.user;
import com.example.demo.dto.userDto;
import com.example.demo.responsitory.userRepository;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class userServiceImpl implements userService{

    @Autowired
    userRepository repository;
    @Override
    public userDto saveOrUpdate(Long Id, userDto dto) {
        if(dto != null){
            user enity = repository.getById(Id);
            if(enity != null)
            {
                enity.setUsername(dto.getUsername());
                enity.setPassword(dto.getPassword());
                enity.setModify_by(dto.getModify_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setId_informarion(dto.getId_information());
                enity.setName(dto.getName());
                enity.setModify_date(date);
                enity.setId_cart(dto.getId_cart());
                enity.setStatus(dto.getStatus());
                enity.setImg(dto.getImg());
                repository.save(enity);
                return dto;
            }
            else {
                user c = new user();
                c.setUsername(dto.getUsername());
                c.setPassword(dto.getPassword());
                c.setCreate_by(dto.getCreate_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                c.setCreate_date(date);
                c.setStatus(dto.getStatus());
                c.setName(dto.getName());
                c.setId_cart(dto.getId_cart());
                c.setId_informarion(dto.getId_information());
                c.setImg(dto.getImg());
                repository.save(c);
                return dto;
            }
        }
        return null;
    }
}
