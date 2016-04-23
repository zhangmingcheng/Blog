package net.zmcheng.action;

import java.io.Serializable;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Message;
import net.zmcheng.model.Messages;
import net.zmcheng.service.messageService;
import net.zmcheng.tool.MyDate;
import net.zmcheng.tool.Paging;

@SuppressWarnings("serial")
public class MessageAction extends ActionSupport implements Serializable,ModelDriven<Paging>{

	private List<Messages> list;// 要返回的某一页的记录
	private int messageId;
	private int id;
	private String content;
	private String time;
	private String sender;
	private String result;
	private String replyResult;
	private Paging paging = new Paging();
	private messageService messageServiceImpl;
	public Paging getModel(){
		return paging;
	}
	//添加留言
    public String add() throws Exception{
    	if(this.getSender().equals("")||this.getContent().equals("")){
    		this.getLists();
    		this.setResult("发送者与内容都不能为空，请重新编写留言");
    		return SUCCESS;
    	}
    	Message message = new Message(this.getSender(),this.getContent(),MyDate.getTime());   	
    	messageServiceImpl.add(message);
    	this.getLists();
    	return SUCCESS;
    }
    //回复留言
    public String addReply() throws Exception{
    	if(this.getSender().equals("")||this.getContent().equals("")){
    		this.getLists();
    		this.setReplyResult("发送者与内容都不能为空，请重新回复留言");
    		return SUCCESS;
    	}
    	Message message = new Message(this.getSender(),this.getContent(),MyDate.getTime(),this.getMessageId());
    	messageServiceImpl.add(message);
    	this.getLists();
    	return SUCCESS;
    }
    //修改审批状况
    public String updateStatus() throws Exception{
    	messageServiceImpl.updateStatus(id);
    	this.getLists();
    	return SUCCESS;
    }
    //删除留言
    public String delete() throws Exception{
    	messageServiceImpl.delete(id);
    	this.getLists();
    	return SUCCESS;
    }
    //得到指定页数的数据
	 public void getLists() throws Exception{
		   int len = messageServiceImpl.getAllMessageNum();
		   int totalpage = paging.countTotalPage(len);
		   paging.setAllRow(len);
		   paging.setTotalPage(totalpage);
		   int start =paging.countOffset();
		   list =  messageServiceImpl.select(start, Paging.getPageSize());
	   }
	 public String execute() throws Exception{
		 this.getLists();
		 return SUCCESS;
	 }
	public List<Messages> getList() {
		return list;
	}

	public void setList(List<Messages> list) {
		this.list = list;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	public messageService getMessageServiceImpl() {
		return messageServiceImpl;
	}
	public void setMessageServiceImpl(messageService messageServiceImpl) {
		this.messageServiceImpl = messageServiceImpl;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getReplyResult() {
		return replyResult;
	}
	public void setReplyResult(String replyResult) {
		this.replyResult = replyResult;
	}
}