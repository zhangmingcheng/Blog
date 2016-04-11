package net.zmcheng.daoImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.articleDao;
import net.zmcheng.model.Article;
@Component
public class articleDaoImpl implements articleDao {
	private  SessionFactory sessionFactory;
	@Override
	public void write(Article article) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(article);
	}

	@Override
	public void update(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void select(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	 @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
