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
@Table(name = "ReplyMessage")
@SuppressWarnings("serial")
public class ReplyMessage implements java.io.Serializable {
	private Integer id;
	private String sender;
	private String content;
	private int status;
	private String time;
	private Message message;
    public ReplyMessage() {
	}
    public ReplyMessage(Message message,String time,String sender,String content) {
		this.message = message;
		this.time = time;
		this.sender = sender;
		this.content = content;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "sender")
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Column(name = "time")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	//optional标示该属性是否允许为空
	@ManyToOne(cascade ={CascadeType.ALL},optional=false,fetch = FetchType.LAZY,targetEntity = Message.class)
	 @JoinColumn(name="messageId")
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
