package net.zmcheng.serviceImpl;

import java.util.List;

import net.zmcheng.dao.messageDao;
import net.zmcheng.model.Message;
import net.zmcheng.service.messageService;
public class messageServiceImpl implements messageService {
	private messageDao messageDaoImpl;
	public void add(Message message) throws Exception {
		messageDaoImpl.add(message);
	}
	public void delete(Message message) throws Exception {
		// TODO Auto-generated method stub

	}
	public void update(Message message) throws Exception {
		// TODO Auto-generated method stub

	}
	public List<Message> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public messageDao getMessageDaoImpl() {
		return messageDaoImpl;
	}
	public void setMessageDaoImpl(messageDao messageDaoImpl) {
		this.messageDaoImpl = messageDaoImpl;
	}

}
