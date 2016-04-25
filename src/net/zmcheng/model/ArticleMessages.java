package net.zmcheng.model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ArticleMessages  implements java.io.Serializable{
     private Integer id;
     private int articleId;
     private String sender;
     private String content;
     private int status;
     private String time;
     private Integer replyId;
     private List<ArticleMessages>messages = new ArrayList<ArticleMessages>();
     public ArticleMessages(){
    	 
     }
     public ArticleMessages(Integer id,int articleId,String sender,String content,String time,Integer replyId,int status){
    	 this.id = id;
    	 this.articleId = articleId;
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
	public List<ArticleMessages> getMessages() {
		return messages;
	}
	public void setMessages(List<ArticleMessages> messages) {
		this.messages = messages;
	}
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
     
}
