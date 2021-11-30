package com.example.demo.dto;

import com.example.demo.domain.information;

import java.util.Date;

public class informationDto {
    private long id;
    private String email;
    private String name;
    private String phone;
    private String address;
    private String create_by;
    private String modify_by;
    private Date create_date;
    private Date modify_date;
    private Boolean status;
    private Long id_user;
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

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public informationDto()
    {

    }

    public informationDto(information entity)
    {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.address = entity.getAddress();
        this.create_by = entity.getCreate_by();
        this.modify_by = entity.getModify_by();
        this.create_date = entity.getCreate_date();
        this.modify_date = entity.getModify_date();
        this.status = entity.getStatus();
        this.id_user = entity.getId_user();
//        if(entity.getUser() != null)
//        {
//            this.user = new userDto();
//            this.user.setId(entity.getUser().getId());
//            this.user.setUsername(entity.getUser().getUsername());
//            this.user.setPassword(entity.getUser().getPassword());
//            this.user.setCreate_by(entity.getUser().getCreate_by());
//            this.user.setModify_by(entity.getUser().getModify_by());
//            this.user.setCreate_date(entity.getUser().getCreate_date());
//            this.user.setCreate_by(entity.getUser().getCreate_by());
//            //this.user.setInformation(entity.getUser().getInformation());
//            this.user.setImg(entity.getUser().getImg());
//        }
        this.img = entity.getImg();
    }
}
