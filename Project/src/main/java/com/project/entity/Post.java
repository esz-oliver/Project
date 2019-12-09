package com.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

@GeneratedValue
@Id
private Long id;
private String title;
@Column(columnDefinition = "TEXT")
private String content;
private Date posted;
@ManyToOne
private User user;

public Post() {
	}

public Post(Long id, String title, String content, Date posted, User user) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.posted = posted;
	this.user = user;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public Date getPosted() {
	return posted;
}

public void setPosted(Date posted) {
	this.posted = posted;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}


}
