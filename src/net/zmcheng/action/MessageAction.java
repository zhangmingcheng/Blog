package net.zmcheng.action;

import java.io.Serializable;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Message;
import net.zmcheng.model.ReplyMessage;
import net.zmcheng.service.messageService;
import net.zmcheng.tool.MyDate;
import net.zmcheng.tool.Paging;

@SuppressWarnings("serial")
public class MessageAction extends ActionSupport implements Serializable,ModelDriven<Paging>{

	private List<Message> list;// 要返回的某一页的记录
	private int messageId;
	private String content;
	private String time;
	private String sender;
	private Paging paging = new Paging();
	private messageService messageServiceImpl;
	public Paging getModel(){
		return paging;
	}
	//添加留言
    public String add() throws Exception{
    	Message message = new Message();
    	message.setContent(this.getContent());
    	message.setTime(MyDate.getTime());
    	message.setSender(this.getSender());
    	messageServiceImpl.add(message);
    	this.getLists();
    	return SUCCESS;
    }
    //添加留言回复
    public String addReply() throws Exception{
       Message message  = messageServiceImpl.getMessageById(messageId);
       ReplyMessage rm = new ReplyMessage(message,this.getTime(),this.getSender(),this.getContent());   
       System.out.println("rm");
       messageServiceImpl.addReply(rm);
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
	public List<Message> getList() {
		return list;
	}

	public void setList(List<Message> list) {
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
}