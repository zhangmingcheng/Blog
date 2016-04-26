package net.zmcheng.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.messageDao;
import net.zmcheng.model.ArticleReply;
import net.zmcheng.model.Message;
import net.zmcheng.model.Messages;

@Component
public class messageDaoImpl implements messageDao {
	private SessionFactory sessionFactory;

	public void add(Message message) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(message);
	}

	public Message getMessageById(int messageId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		return (Message) session.get(Message.class, messageId);
	}

	public int getAllMessageNum() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Message");
		List list = query.list();
		return list.size();
	}

	public void Delete(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Message mes = (Message) session.get(Message.class, id);
		if(mes.getReplyId()==null){
			Query query = session.createQuery("from Message as  u where u.replyId=:tempReplyId");
			query.setInteger("tempReplyId", id);
			List<Message> result = query.list();
			for (Message temp : result) {
				session.delete(temp);}
		}
		else{
			Query query = session.createQuery("from Message as  u where u.replyId=:tempReplyId and u.id>:tempId");
			int tempReplyId = mes.getReplyId();
			query.setInteger("tempReplyId", tempReplyId);
			query.setInteger("tempId", id);
			List<Message> result = query.list();
			for (Message temp : result) {
				session.delete(temp);
			}
		}
		session.delete(mes);
		return;
	}

	@Override
	public void update(Message message) throws Exception {
		// TODO Auto-generated method stub

	}

	public void updateStatus(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Message mes = (Message) session.get(Message.class, id);
		mes.setStatus(1);
		session.update(mes);
	}

	@Override
	public List<Messages> getAllMessage(final int start, final int length) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Messages> messages = new ArrayList<Messages>();
		Query query = session.createQuery("from Message as  u order by u.id desc");
		query.setFirstResult(start);
		query.setMaxResults(length);
		List<Message> result = query.list();
		for (Message temp : result) {
			Messages tempMess = new Messages(temp.getId(), temp.getSender(), temp.getContent(), temp.getTime(),
					temp.getReplyId(), temp.getStatus());
			if (temp.getReplyId() != null) {
				Query query2 = session
						.createQuery("from Message as u where (u.replyId=:tempId or u.id=:tempId) and u.id<:zanId");
				query2.setInteger("tempId", temp.getReplyId());
				query2.setInteger("zanId", temp.getId());
				List<Message> result2 = query2.list();
				List<Messages> list2 = new ArrayList<Messages>();
				for (int i = 0; i < result2.size(); i++) {
					Messages tempMess2 = new Messages(result2.get(i).getId(), result2.get(i).getSender(),
							result2.get(i).getContent(), result2.get(i).getTime(), result2.get(i).getReplyId(),
							result2.get(i).getStatus());
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
