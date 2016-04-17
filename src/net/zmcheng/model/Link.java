package net.zmcheng.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Link")
@SuppressWarnings("serial")
public class Link implements java.io.Serializable {
	private Integer id;
	private String name;
	private String url;
	private User user;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	 @Column(name="name") 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 @Column(name="url") 
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@ManyToOne(cascade ={CascadeType.ALL},optional=false,fetch =FetchType.LAZY,targetEntity = Province.class)		
	 @JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

