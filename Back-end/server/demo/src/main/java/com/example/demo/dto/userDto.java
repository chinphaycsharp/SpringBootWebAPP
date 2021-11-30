package com.example.demo.dto;

import com.example.demo.domain.user;

import java.util.Collection;
import java.util.Date;

public class userDto {

    private long id;
    private String password;
    private String create_by;
    private String modify_by;
    private Date create_date;
    private Date modify_date;
    private Boolean status;
    private String username;
    private String img;
    private Long id_information;
    private String name;
    private Long id_cart;

    public Long getId_cart() {
        return id_cart;
    }

    public void setId_cart(Long id_cart) {
        this.id_cart = id_cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_information() {
        return id_information;
    }

    public void setId_information(Long id_information) {
        this.id_information = id_information;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public userDto(){

    }

    public userDto(user entity)
    {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.create_by = entity.getCreate_by();
        this.modify_by = entity.getModify_by();
        this.create_date = entity.getCreate_date();
        this.modify_date = entity.getModify_date();
        this.status = entity.getStatus();
        this.img = entity.getImg();
        this.name = entity.getName();
//        if (entity.getInformation() != null)
//        {
//            this.informationDto = new informationDto();
//            this.informationDto.setId(entity.getInformation().getId());
//            this.informationDto.setName(entity.getInformation().getName());
//            this.informationDto.setPhone(entity.getInformation().getPhone());
//            this.informationDto.setAddress(entity.getInformation().getAddress());
//            this.informationDto.setCreate_by(entity.getInformation().getCreate_by());
//            this.informationDto.setModify_by(entity.getInformation().getModify_by());
//            this.informationDto.setCreate_date(entity.getInformation().getCreate_date());
//            this.informationDto.setCreate_by(entity.getInformation().getCreate_by());
//            this.informationDto.setStatus(entity.getInformation().getStatus());
//            this.informationDto.setImg(entity.getInformation().getImg());
//        }
    }
}
