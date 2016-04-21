package net.zmcheng.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.zmcheng.dao.messageDao;
import net.zmcheng.model.Message;
import net.zmcheng.model.Messages;
import net.zmcheng.service.messageService;
@Component
public class messageServiceImpl implements messageService {
	private messageDao messageDaoImpl;
	public void add(Message message) throws Exception {
		messageDaoImpl.add(message);
	}
	public void updateStatus(int id) throws Exception{
		messageDaoImpl.updateStatus(id);
	}
	 public Message getMessageById(int messageId) throws Exception{
		 return messageDaoImpl. getMessageById(messageId);
	 }
	public int getAllMessageNum() throws Exception{
		 return  messageDaoImpl.getAllMessageNum();
	 }
	public void delete(int id) throws Exception {
		messageDaoImpl.Delete(id);
	}
	public void update(Message message) throws Exception {
		// TODO Auto-generated method stub

	}
	public List<Messages> select(final int start,final int  length) throws Exception{
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
