package com.example.demo.service.impl;

import com.example.demo.dto.courseDto;
import com.example.demo.responsitory.courseRespository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.course;
import com.example.demo.service.courseService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class courseServiceImpl implements courseService {

    @Autowired
    courseRespository service;

    @Autowired
    EntityManager manager;

    @Override
    public courseDto saveOrUpdate(Long Id, courseDto dto) {
        if(dto != null){
            course enity = service.getById(Id);
            if(enity != null)
            {
                enity.setName(dto.getName());
                enity.setModify_by(dto.getCreate_by());
                enity.setDescription(dto.getDescription());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setModify_date(date);
                enity.setSession(dto.getSession());
                enity.setStatus(dto.getStatus());
                enity.setId_category(dto.getId_category());
                enity.setId_type(dto.getId_type());
                enity.setId_user(dto.getId_user());
                enity.setImg(dto.getImg());
                service.save(enity);
                return dto;
            }
            else {
                course c = new course();
                c.setName(dto.getName());
                c.setCreate_by(dto.getCreate_by());
                c.setDescription(dto.getDescription());
                c.setModify_by(null);
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                c.setCreate_date(date);
                c.setSession(dto.getSession());
                c.setStatus(dto.getStatus());
                c.setImg(dto.getImg());
                c.setId_category(dto.getId_category());
                c.setId_type(dto.getId_type());
                c.setId_user(dto.getId_user());
                service.save(c);
                return dto;
            }
        }
        return null;
    }

    @Override
    public List<courseDto> getCourseManyUser() {
        String sql = "select new com.example.demo.dto.courseDto(c) from course c join user u " +
                "on u.id = c.id_user group by c.id_user order by count(*) desc";

        Query q = manager.createQuery(sql, courseDto.class);
        List<courseDto> dtos = q.getResultList();
        return dtos;
    }

    @Override
    public List<courseDto> getCourseByName(String name) {
        String sql = "select new com.example.demo.dto.courseDto(c) from course c";
        String whereClause = "";

        if(name != null)
        {
            whereClause += " where c.name like :name";
        }

        sql += whereClause;

        Query q = manager.createQuery(sql, courseDto.class);
        if(name != null)
        {
            q.setParameter("name","%"+name+"%");
        }

        List<courseDto> dtos = q.getResultList();
        return dtos;
    }
}
