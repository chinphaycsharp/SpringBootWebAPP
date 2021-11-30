package com.example.demo.service.impl;
import com.example.demo.domain.type;
import com.example.demo.dto.courseDto;
import com.example.demo.dto.typeDto;
import com.example.demo.service.typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.responsitory.typeRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class typeServiceImpl implements typeService{

    @Autowired
    typeRepository repository;

    @Autowired
    EntityManager manager;

    @Override
    public typeDto saveOrUpdate(Long Id, typeDto dto) {
        if(dto != null){
            type enity = repository.getById(Id);
            if(enity != null)
            {
                enity.setName(dto.getName());
                enity.setModify_by(dto.getModify_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setModify_date(date);
                repository.save(enity);
                return dto;
            }
            else {
                type c = new type();
                c.setName(dto.getName());
                c.setCreate_by(dto.getCreate_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                c.setCreate_date(date);
                repository.save(c);
                return dto;
            }
        }
        return null;
    }
}
