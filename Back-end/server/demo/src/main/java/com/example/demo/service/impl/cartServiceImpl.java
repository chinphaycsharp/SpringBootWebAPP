package com.example.demo.service.impl;

import com.example.demo.domain.cart;
import com.example.demo.domain.category;
import com.example.demo.dto.cartDto;
import com.example.demo.responsitory.cartRepository;
import com.example.demo.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
@Service
public class cartServiceImpl implements cartService {

    @Autowired
    cartRepository service;

    @Override
    public cartDto saveOrUpdate(Long Id, cartDto dto) {
        if(dto != null){
            cart enity = service.getById(Id);
            if(enity != null)
            {
                enity.setName(dto.getName());
                enity.setTitle(dto.getTitle());
                enity.setDescription(dto.getDescription());
                enity.setModify_by(dto.getCreate_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setModify_date(date);
                enity.setStatus(dto.getStatus());
                enity.setId_user(dto.getId_user());
                service.save(enity);
                return dto;
            }
            else {
                cart c = new cart();
                c.setName(dto.getName());
                c.setTitle(dto.getTitle());
                c.setDescription(dto.getDescription());
                c.setCreate_by(dto.getCreate_by());
                c.setModify_by(null);
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                c.setCreate_date(date);
                c.setStatus(dto.getStatus());
                c.setId_user(dto.getId_user());
                service.save(c);
                return dto;
            }
        }
        return null;
    }
}
