package net.zmcheng.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.messageDao;
import net.zmcheng.model.Article;
import net.zmcheng.model.Message;
@Component
public class messageDaoImpl implements messageDao {
	private  SessionFactory sessionFactory;
	public void add(Message message) throws Exception {
		  Session session = sessionFactory.getCurrentSession();
		  session.save(message);
	}
	public int getAllMessageNum() throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Message");
		List list =  query.list();
		return list.size();
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
	public List<Message>getAllMessage(final int start,final int  length) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		List<Message> temp = new  ArrayList<Message>();
		Query query = session.createQuery("from Message as  u order by u.id desc");
		query.setFirstResult(start);
		query.setMaxResults(length);
		temp = query.list();
		return temp;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
