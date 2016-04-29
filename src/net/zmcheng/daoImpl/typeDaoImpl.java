package net.zmcheng.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.typeDao;
import net.zmcheng.model.Type;
@Component
public class typeDaoImpl implements typeDao {
	private SessionFactory sessionFactory;
	public void add(Type type) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
		session.save(type);
	}

	public void delete(Type type) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
        session.delete(type);
	}
	//判断删除记录后应该停留在哪一页
	public int getTypeNum(int Id) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Type as c where c.id > :Id");
		query.setInteger("Id", Id);
		List list =  query.list();
		return list.size();
	}
	public List<Type> selectAllType(int start, int length) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
		List<Type> temp = new  ArrayList<Type>();
		Query query = session.createQuery("from Type as  u order by u.id desc");
		query.setFirstResult(start);
		query.setMaxResults(length);
		temp = query.list();
		return temp;
	}

	public void update(Type type) throws Exception {
		 Session session = sessionFactory.getCurrentSession();
		 session.update(type);
	}

	public int getAllType() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Type");
		List list = query.list();
		return list.size();
	}

	public Type getType(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		 return (Type)session.get(Type.class,id);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
   @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
