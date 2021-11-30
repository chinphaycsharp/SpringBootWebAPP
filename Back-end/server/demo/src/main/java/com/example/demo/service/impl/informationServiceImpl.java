package com.example.demo.service.impl;

import com.example.demo.domain.information;
import com.example.demo.dto.informationDto;
import com.example.demo.responsitory.informationRepository;
import com.example.demo.service.informationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class informationServiceImpl implements informationService {

    @Autowired
    informationRepository repository;

    @Override
    public informationDto saveOrUpdate(Long Id, informationDto dto) {
        if(dto != null){
            information enity = repository.getById(Id);
            if(enity != null)
            {
                enity.setEmail(dto.getEmail());
                enity.setName(dto.getName());
                enity.setPhone(dto.getPhone());
                enity.setAddress(dto.getAddress());
                enity.setModify_by(dto.getModify_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setModify_date(date);
                enity.setStatus(dto.getStatus());
                enity.setImg(dto.getImg());
                repository.save(enity);
                return dto;
            }
            else {
                information c = new information();
                c.setEmail(dto.getEmail());
                c.setName(dto.getName());
                c.setPhone(dto.getPhone());
                c.setAddress(dto.getAddress());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                c.setCreate_by(dto.getCreate_by());
                c.setCreate_date(date);
                c.setStatus(dto.getStatus());
                c.setImg(dto.getImg());
                repository.save(c);
                return dto;
            }
        }
        return null;
    }
}
