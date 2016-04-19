package net.zmcheng.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.messageDao;
import net.zmcheng.model.Message;
import net.zmcheng.model.Messages;
@Component
public class messageDaoImpl implements messageDao {
	private  SessionFactory sessionFactory;
	public void add(Message message) throws Exception {
		  Session session = sessionFactory.getCurrentSession();
		  session.save(message);
	}
	 public Message getMessageById(int messageId) throws Exception{
			Session session = sessionFactory.getCurrentSession();		
			return (Message)session.get(Message.class, messageId);
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
	public List<Messages>getAllMessage(final int start,final int  length) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		List<Messages> messages = new  ArrayList<Messages>();
		Query query = session.createQuery("from Message as  u order by u.id desc");
		query.setFirstResult(start);
		query.setMaxResults(length);
		List<Message> result = query.list();
		for(Message temp:result){
			System.out.println("sender="+temp.getSender());
			Messages tempMess = new Messages(temp.getId(),temp.getSender(),temp.getContent(),temp.getTime());
			if(temp.getReplyId()!=null){
			Query query2 = session.createQuery("from Message as u where u.replyId=:tempId or u.id=:tempId");
			query2.setInteger("tempId", temp.getReplyId());
			List<Message> result2 = query2.list();
			List<Messages> list2 = new ArrayList<Messages>();			
			for(Message temp2:result2){
				System.out.println("sender=="+temp2.getSender());
				Messages tempMess2 = new Messages(temp2.getId(),temp2.getSender(),temp2.getContent(),temp2.getTime());
				list2.add(tempMess2);
			}
			tempMess.setMessages(list2);
			}
		    messages.add(tempMess);
		}
		return messages;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
