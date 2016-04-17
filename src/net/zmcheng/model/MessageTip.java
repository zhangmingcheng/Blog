package net.zmcheng.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
public class MessageTip  implements java.io.Serializable{
	     private Integer id;
	     private User user;
	     private String sender;
	     private Integer status;
	     private Date time =new Date();
	    @Id
	    @GeneratedValue
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		@ManyToOne(cascade ={CascadeType.ALL},optional=false,fetch = FetchType.LAZY,targetEntity = MessageTip.class)
		 @JoinColumn(name="getId")
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		@Column(name="sender")
		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}
		@Column(name="time")
		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}
		@Column(name="status")
		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}
	     
	}
