package net.zmcheng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Link")
@SuppressWarnings("serial")
public class Link implements java.io.Serializable {
	private Integer id;
	private String name;
	private String url;
	private String time;
    public Link(){
    }
    public Link(String name,String url,String time){
    	this.name = name;
    	this.url = url;
    	this.time = time;
    }
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
	@Column(name="time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}

