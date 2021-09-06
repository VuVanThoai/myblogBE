package com.thoaidz.blog.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_category")
	private int idCategory;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "img_instead")
	private String imgInstead;
	
	@Column(name = "body")
	private String body;
	
	@Column(name = "tag")
	private String tag;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "view")
	private int view;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgInstead() {
		return imgInstead;
	}

	public void setImgInstead(String imgInstead) {
		this.imgInstead = imgInstead;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
	

}
