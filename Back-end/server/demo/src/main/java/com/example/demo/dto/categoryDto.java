package com.example.demo.dto;

import com.example.demo.domain.category;

import java.util.Collection;
import java.util.Date;

public class categoryDto {
    private long id;
    private String name;
    private String title;
    private String description;
    private String create_by;
    private String modify_by;
    private Date create_date;
    private Date modify_date;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public categoryDto(category entity)
    {
        this.id = entity.getId();
        this.name = entity.getName();
        this.title = entity.getTitle();
        this.create_by = entity.getCreate_by();
        this.modify_by = entity.getModify_by();
        this.create_date = entity.getCreate_date();
        this.modify_date = entity.getModify_date();
        this.status = entity.getStatus();
    }

    public categoryDto(){

    }
}
