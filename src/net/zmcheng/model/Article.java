package net.zmcheng.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Article")
@SuppressWarnings("serial")
public class Article implements java.io.Serializable{
	 private Integer id;
	 private User user;
	 private Set<ArticleReply> articleReplys = new HashSet<ArticleReply>();  
     private String title;
     private int readNum;
     private String postdate;
     private String content;
     private int zanNum;
     private String brief;
     private int messageNum;
     @Id
     @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(optional=false,targetEntity = User.class)//默认立即加载
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
	public String  getPostdate() {
		return postdate;
	}

	public void setPostdate(String  postdate) {
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
   @OneToMany(cascade=(CascadeType.REMOVE),mappedBy="article")//默认延迟加载
	public Set<ArticleReply> getArticleReplys() {
		return articleReplys;
	}

	public void setArticleReplys(Set<ArticleReply> articleReplys) {
		this.articleReplys = articleReplys;
	}
	  @Transient
	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}


}
