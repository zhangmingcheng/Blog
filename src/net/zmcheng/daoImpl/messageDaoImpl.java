package net.zmcheng.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import net.zmcheng.dao.messageDao;
import net.zmcheng.model.Message;

public class messageDaoImpl implements messageDao {
	private  SessionFactory sessionFactory;
	public void add(Message message) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Message message) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Message message) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
