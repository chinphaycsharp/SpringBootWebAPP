package com.example.demo.dto;

import com.example.demo.domain.user_course;

import java.util.Date;

public class user_courseDto {
    private long id;
    private String nameUser;
    private String nameCourse;
    private String create_by;
    private String modify_by;
    private Date create_date;
    private Date modify_date;
    private int status;
    private int session;
    private Boolean isDone;
    private Long id_user;
    private Long id_course;
    private String img;
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getModify_by() {
        return modify_by;
    }

    public void setModify_by(String modify_by) {
        this.modify_by = modify_by;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_course() {
        return id_course;
    }

    public void setId_course(Long id_course) {
        this.id_course = id_course;
    }

    public user_courseDto(){

    }

    public user_courseDto (user_course entity){
        super();
        this.id = entity.getId();
        this.nameUser = entity.getNameUser();
        this.nameCourse = entity.getNameCourse();
        this.create_by = entity.getCreate_by();
        this.modify_by = entity.getModify_by();
        this.create_date = entity.getCreate_date();
        this.modify_date = entity.getModify_date();
        this.status = entity.getStatus();
        this.session = entity.getSession();
        this.isDone = entity.getDone();
        this.id_course = entity.getId_course();
        this.id_user = entity.getId_user();
        this.img = entity.getImg();
    }
}
