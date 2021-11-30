package com.example.demo.service.impl;

import com.example.demo.domain.session;
import com.example.demo.dto.sessionDto;
import com.example.demo.responsitory.sessionRepository;
import com.example.demo.service.sessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class sessionServiceImpl implements  sessionService{

    @Autowired
    sessionRepository repository;

    @Override
    public sessionDto saveOrUpdate(Long Id, sessionDto dto) {
        if(dto != null){
            session enity = repository.getById(Id);
            if(enity != null)
            {
                enity.setName(dto.getName());
                enity.setContent(dto.getContent());
                enity.setModify_by(dto.getModify_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setModify_date(date);
                enity.setTime_show(dto.getTime_show());
                //enity.setId_course(dto.getId_course());
                enity.setImg(dto.getImg());
                enity.setVideo(dto.getVideo());
                repository.save(enity);
                return dto;
            }
            else {
                session c = new session();
                c.setName(dto.getName());
                c.setContent(dto.getContent());
                c.setCreate_by(dto.getCreate_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                c.setCreate_date(date);
                c.setTime_show(dto.getTime_show());
                //c.setId_course(dto.getId_course());
                c.setImg(dto.getImg());
                c.setVideo(dto.getVideo());
                repository.save(c);
                return dto;
            }
        }
        return null;
    }
}
