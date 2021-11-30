package com.example.demo.dto;

import com.example.demo.domain.session;

import java.util.Date;

public class sessionDto {

    private long id;
    private String name;
    private String content;
    private String create_by;
    private String modify_by;
    private Date create_date;
    private Date modify_date;
    private int time_show;
    private Long id_course;
    private String img;
    private String video;
    private typeDto typeDto;
    private Long id_cart;

    public Long getId_cart() {
        return id_cart;
    }

    public void setId_cart(Long id_cart) {
        this.id_cart = id_cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getTime_show() {
        return time_show;
    }

    public void setTime_show(int time_show) {
        this.time_show = time_show;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public typeDto getId_type() {
        return typeDto;
    }

    public void setId_type(typeDto typeDto) {
        this.typeDto = typeDto;
    }

    public Long getId_course() {
        return id_course;
    }

    public void setId_course(Long id_course) {
        this.id_course = id_course;
    }

    public sessionDto()
    {

    }

    public sessionDto(session entity)
    {
        this.id = entity.getId();
        this.name = entity.getName();
        this.content = entity.getContent();
        this.create_by = entity.getCreate_by();
        this.modify_by = entity.getModify_by();
        this.create_date = entity.getCreate_date();
        this.modify_date = entity.getModify_date();
        this.time_show = entity.getTime_show();
        this.id_course = entity.getId_course();
        this.img = entity.getImg();
        this.video = entity.getVideo();
    }
}
