package com.example.demo.dto;

import com.example.demo.domain.course;

import java.util.Collection;
import java.util.Date;

public class courseDto{
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String create_by;
	private String modify_by;
	private Date create_date;
	private Date modify_date;
	private int session;
	private Boolean status;
	private String img;
	private Long id_category;
	private Long id_user;
	private Long id_type;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId_type() {
		return id_type;
	}

	public void setId_type(Long id_type) {
		this.id_type = id_type;
	}

	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
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

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public courseDto(course entity)
	{
		this.id = entity.getId();
		this.name = entity.getName();
		this.create_by = entity.getCreate_by();
		this.modify_by = entity.getModify_by();
		this.create_date = entity.getCreate_date();
		this.modify_date = entity.getModify_date();
		this.session = entity.getSession();
		this.status = entity.getStatus();
		this.img = entity.getImg();
		this.description = entity.getDescription();
		this.id_category = entity.getId_category();
		this.id_type = entity.getId_type();
		this.id_user = entity.getId_user();
	}

	public courseDto(){

	}
}
