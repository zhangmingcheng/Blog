package net.zmcheng.model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Messages  implements java.io.Serializable{
     private Integer id;
     private String sender;
     private String content;
     private int status;
     private String time;
     private Integer replyId;
     private List<Messages>messages = new ArrayList<Messages>();
     public Messages(){
    	 
     }
     public Messages(Integer id,String sender,String content,String time,Integer replyId,int status){
    	 this.id = id;
       	 this.sender = sender;
    	 this.content = content;
    	 this.time = time;
    	 this.replyId = replyId;
    	 this.status = status;
     }
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public List<Messages> getMessages() {
		return messages;
	}
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
     
}
