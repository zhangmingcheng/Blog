package net.zmcheng.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.zmcheng.dao.messageDao;
import net.zmcheng.model.Message;
import net.zmcheng.model.ReplyMessage;
import net.zmcheng.service.messageService;
@Component
public class messageServiceImpl implements messageService {
	private messageDao messageDaoImpl;
	public void add(Message message) throws Exception {
		messageDaoImpl.add(message);
	}
	 public void addReply(ReplyMessage rm) throws Exception{
		  System.out.println("hhhhh");
		 messageDaoImpl.addReply(rm);
	 }
	 public Message getMessageById(int messageId) throws Exception{
		 return messageDaoImpl. getMessageById(messageId);
	 }
	public int getAllMessageNum() throws Exception{
		 return  messageDaoImpl.getAllMessageNum();
	 }
	public void delete(Message message) throws Exception {
		// TODO Auto-generated method stub

	}
	public void update(Message message) throws Exception {
		// TODO Auto-generated method stub

	}
	public List<Message> select(final int start,final int  length) throws Exception{
		return  messageDaoImpl.getAllMessage(start,length);
	}

	public messageDao getMessageDaoImpl() {
		return messageDaoImpl;
	}
	@Resource
	public void setMessageDaoImpl(messageDao messageDaoImpl) {
		this.messageDaoImpl = messageDaoImpl;
	}

}
