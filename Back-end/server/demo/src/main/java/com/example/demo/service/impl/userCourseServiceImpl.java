package com.example.demo.service.impl;

import com.example.demo.domain.user_course;
import com.example.demo.dto.courseDto;
import com.example.demo.dto.user_courseDto;
import com.example.demo.responsitory.userCourseRespository;
import com.example.demo.service.userCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class userCourseServiceImpl implements userCourseService {

    @Autowired
    userCourseRespository service;

    @Autowired
    EntityManager manager;

    @Override
    public user_courseDto saveOrUpdate(Long Id, user_courseDto dto) {
        if(dto != null){
            user_course enity = service.getById(Id);
            if(enity != null)
            {
                enity.setNameUser(dto.getNameUser());
                enity.setNameCourse(dto.getNameCourse());
                enity.setModify_by(dto.getCreate_by());
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                enity.setModify_date(date);
                enity.setStatus(dto.getStatus());
                enity.setSession(dto.getSession());
                enity.setDone(dto.getDone());
                enity.setId_course(dto.getId_course());
                enity.setId_user(dto.getId_user());
                enity.setImg(dto.getImg());
                service.save(enity);
                return dto;
            }
            else {
                List<user_courseDto> dtos = getUserRegisterCourse(dto.getId_user(),dto.getId_course());
                if(dtos.size() == 0)
                {
                    user_course c = new user_course();
                    c.setNameUser(dto.getNameUser());
                    c.setNameCourse(dto.getNameCourse());
                    c.setCreate_by(dto.getCreate_by());
                    LocalDate localDate = LocalDate.now();
                    Date date = java.sql.Date.valueOf(localDate);
                    c.setCreate_date(date);
                    c.setStatus(dto.getStatus());
                    c.setSession(dto.getSession());
                    c.setDone(false);
                    c.setId_course(dto.getId_course());
                    c.setId_user(dto.getId_user());
                    c.setImg(dto.getImg());
                    service.save(c);
                    return dto;
                }
                else{
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public List<user_courseDto> getUserRegisterCourse(Long id_user, Long id_course) {
        String sql = "select new com.example.demo.dto.user_courseDto(uc) from user_course uc " +
                "join course c on uc.id_course = c.id";

        String whereClause = "";

        if(id_user != null && id_course != null)
        {
            whereClause += " where uc.id_user =: id_user and uc.id_course =: id_course";
        }

        sql += whereClause;

        Query q = manager.createQuery(sql, user_courseDto.class);

        if(id_user != null)
        {
            q.setParameter("id_user",id_user);
        }

        if(id_course != null)
        {
            q.setParameter("id_course",id_course);
        }

        List<user_courseDto> dtos = q.getResultList();
        return dtos;
    }

}
