package com.example.demo.service.impl;

import com.example.demo.domain.message;
import com.example.demo.dto.messageDto;
import com.example.demo.responsitory.messageRepository;
import com.example.demo.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class messageServiceImpl implements messageService {

    @Autowired
    messageRepository repository;

    @Override
    public messageDto saveOrUpdate(Long Id, messageDto dto) {
        if(dto != null){
            message enity = repository.getById(Id);
            if(enity != null)
            {
                enity.setContent(dto.getContent());
                enity.setModify_by(dto.getModify_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setModify_date(date);
                enity.setStatus(dto.getStatus());
                enity.setId_user(dto.getId_user());
                enity.setId_admin(dto.getId_admin());
                repository.save(enity);
                return dto;
            }
            else {
                message m = new message();
                m.setContent(dto.getContent());
                m.setCreate_by(dto.getModify_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                m.setCreate_date(date);
                m.setStatus(dto.getStatus());
                m.setId_user(dto.getId_user());
                m.setId_admin(dto.getId_admin());
                m.setStatus(dto.getStatus());
                repository.save(m);
                return dto;
            }
        }
        return null;
    }
}
