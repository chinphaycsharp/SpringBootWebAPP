package com.example.demo.service.impl;

import com.example.demo.domain.contact;
import com.example.demo.dto.contactDto;
import com.example.demo.responsitory.contactRepository;
import com.example.demo.service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class contactServiceImpl implements contactService {

    @Autowired
    contactRepository repository;

    @Override
    public contactDto saveOrUpdate(Long Id, contactDto dto) {
        if(dto != null){
            contact enity = repository.getById(Id);
            if(enity != null)
            {
                enity.setName(dto.getName());
                enity.setPhone(dto.getPhone());
                enity.setAddress(dto.getAddress());
                enity.setEmail(dto.getEmail());
                enity.setIntroduce(dto.getIntroduce());
                enity.setModify_by(dto.getCreate_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setModify_date(date);
                repository.save(enity);
                return dto;
            }
            else {
                contact c = new contact();
                c.setName(dto.getName());
                c.setPhone(dto.getPhone());
                c.setAddress(dto.getAddress());
                c.setEmail(dto.getEmail());
                c.setIntroduce(dto.getIntroduce());
                c.setCreate_by(dto.getCreate_by());
                c.setModify_by(null);
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
