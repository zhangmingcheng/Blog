package net.zmcheng.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Article")
@SuppressWarnings("serial")
public class Article implements java.io.Serializable{
	 private Integer id;
	 private User user;
     private String title;
     private int readNum;
     private Date postdate = new Date();
     private String content;
     private int zanNum;
     private String brief;
     @Id
     @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(cascade ={CascadeType.ALL},optional=false,targetEntity = User.class)
	 @JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	 
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="readNum")
	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	@Column(name="postdate")
	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
  @Column(name="zanNum")
	public int getZanNum() {
		return zanNum;
	}

	public void setZanNum(int zanNum) {
		this.zanNum = zanNum;
	}
  @Column(name="brief")
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

}
