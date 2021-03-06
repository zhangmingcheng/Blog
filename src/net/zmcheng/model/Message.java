package net.zmcheng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Message")
@SuppressWarnings("serial")
public class Message  implements java.io.Serializable{
     private Integer id;
     private Integer replyId;
     private String sender;
     private String content;
     private int status;
     private String time;
     public Message(){
    	 
     }
     public Message(String sender,String content,String time){
       	 this.sender = sender;
    	 this.content = content;
    	 this.time = time;
     }
     public Message(String sender,String content,String time,int replyId){
       	 this.sender = sender;
    	 this.content = content;
    	 this.time = time;
    	 this.replyId = replyId;
     }
    @Id
    @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="sender")
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	@Column(name="time")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    @Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name="replyId")
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}     
}
