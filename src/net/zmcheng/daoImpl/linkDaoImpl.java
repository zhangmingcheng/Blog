package net.zmcheng.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.linkDao;
import net.zmcheng.model.Article;
import net.zmcheng.model.Link;
@Component
public class linkDaoImpl implements linkDao {
    private SessionFactory sessionFactory;
	public void add(Link link) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
		session.save(link);
	}
	public int getArticleNum(int Id) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Link as c where c.id > :Id");
		query.setInteger("Id", Id);
		List list =  query.list();
		return list.size();
	}
	public void delete(Link link) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
        session.delete(link);
	}
	public List<Link> selectAllLink(final int start,final int  length) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
		List<Link> temp = new  ArrayList<Link>();
		Query query = session.createQuery("from Link as  u order by u.id desc");
		query.setFirstResult(start);
		query.setMaxResults(length);
		temp = query.list();
		return temp;
	}

	@Override
	public void update(Link link) throws Exception {
		// TODO Auto-generated method stub

	}

	public int getAllLink() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Link");
		List list = query.list();
		return list.size();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
   @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
