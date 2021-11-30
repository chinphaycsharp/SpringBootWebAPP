package com.example.demo.service.impl;

import com.example.demo.domain.category;
import com.example.demo.dto.categoryDto;
import com.example.demo.responsitory.categoryRepository;
import com.example.demo.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class categoryServiceImpl implements categoryService {

    @Autowired
    categoryRepository service;

    @Override
    public categoryDto saveOrUpdate(Long Id, categoryDto dto) {
        if(dto != null){
            category enity = service.getById(Id);
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
                service.save(enity);
                return dto;
            }
            else {
                category c = new category();
                c.setName(dto.getName());
                c.setTitle(dto.getTitle());
                c.setDescription(dto.getDescription());
                c.setCreate_by(dto.getCreate_by());
                c.setModify_by(null);
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                c.setCreate_date(date);
                c.setStatus(dto.getStatus());
                service.save(c);
                return dto;
            }
        }
        return null;
    }
}
