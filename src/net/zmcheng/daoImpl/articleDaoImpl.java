package net.zmcheng.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.articleDao;
import net.zmcheng.model.Article;
@Component
public class articleDaoImpl implements articleDao {
	private  SessionFactory sessionFactory;
	//得到所有博文
	public int getAllArticle() throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Article");
		List list =  query.list();
		return list.size();
	}
	public int getArticleNum(int Id) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Article as c where c.id < :Id");
		query.setInteger("Id", Id);
		List list =  query.list();
		return list.size();
	}
	//分页查询数据setFirstResult(start)中索引start是从0开始的
	public List<Article> getArticles(final int start,final int  length) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		List<Article> temp = new  ArrayList<Article>();
		Query query = session.createQuery("from Article");
		query.setFirstResult(start);
		query.setMaxResults(length);
		temp = query.list();
		return temp;
	}
	//写博客
	public void write(Article article) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(article);
	}
   //得到指定博文
	public Article getArticle(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		return (Article)session.get(Article.class,id);
	}
   //更新博文
	public void update(Article article) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(article);

	}

	@Override
	public void select(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Article article) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(article);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	 @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
