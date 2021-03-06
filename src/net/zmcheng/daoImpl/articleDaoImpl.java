package net.zmcheng.daoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.articleDao;
import net.zmcheng.model.Article;
import net.zmcheng.model.ArticleMessages;
import net.zmcheng.model.ArticleReply;
import net.zmcheng.model.Message;
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
		Query query = session.createQuery("from Article as c where c.id > :Id");
		query.setInteger("Id", Id);
		List list =  query.list();
		return list.size();
	}
	//分页查询数据setFirstResult(start)中索引start是从0开始的
	public List<Article> getArticles(final int start,final int  length) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		List<Article> temp = new  ArrayList<Article>();
		Query query = session.createQuery("from Article as  u order by u.id desc");
		query.setFirstResult(start);
		query.setMaxResults(length);
		temp = query.list();
		return temp;
	}
	public List<Article> getKeyArticles(String keyWord) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		List<Article> temp = new  ArrayList<Article>();
		List<Article> temp2 = new  ArrayList<Article>();
		Query query = session.createQuery("from Article as  u order by u.id desc");
		temp = query.list();
		for(Article article:temp){
           //正则	
			Pattern p = Pattern.compile(keyWord);
			Matcher m = p.matcher( article.getTitle());
			boolean result = m.find();
			if( result==true){
				temp2.add(article);
			}
		}
		return temp2;
	}
	public List<Article> getALLArticle() throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		List<Article> temp = new  ArrayList<Article>();
		Query query = session.createQuery("from Article as  u order by u.id desc");
		temp = query.list();
		return temp;
	}
	public List<Article> getHotArticle() throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		List<Article> temp = new  ArrayList<Article>();
		Query query = session.createQuery("from Article as  u order by u.readNum desc");
		query.setFirstResult(0);
		query.setMaxResults(8);
		temp = query.list();
		return temp;
	}
	public List<Article> getTypeArticles(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();		
		List<Article> temp = new  ArrayList<Article>();
		Query query = session.createQuery("from Article as  u where typeId=:tempId order by u.id desc");
	   query.setInteger("tempId", id);
		temp = query.list();
		return temp;
	}
	//写博客
	public void write(Article article) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(article);
	}
	public int getArticleMessageNum(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Article article = (Article)session.get(Article.class,id);
		Set<ArticleReply> sets = article.getArticleReplys();
		return sets.size();
	}
   //得到指定博文
	public Article getArticle(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Article article = (Article)session.get(Article.class,id);
		return article;
	}
	//得到指定博文的所有留言
    public List<ArticleMessages> getAllArticleMessage(int id) throws Exception{
    	Session session = sessionFactory.getCurrentSession();
		Article article = (Article)session.get(Article.class,id);
		Set<ArticleReply> sets = article.getArticleReplys();
		List<ArticleMessages> messages = new ArrayList<ArticleMessages>();
	    List<ArticleReply> Result = new ArrayList<ArticleReply>();
    	Result.addAll(sets);
    	 Collections.sort(Result, new Comparator<ArticleReply>(){  
             public int compare(ArticleReply o1, ArticleReply o2) {          
                 if(o1.getId()< o2.getId()){  //按id从大到小排序
                     return 1;  
                 }  
                 if(o1.getId() == o2.getId()){  
                     return 0;  
                 }  
                 return -1;  
             }  
         });   
		for (ArticleReply temp : Result) {
			ArticleMessages tempMess = new ArticleMessages(temp.getId(), temp.getArticle().getId(),temp.getSender(), temp.getContent(), temp.getTime(),
					temp.getReplyId(), temp.getStatus());
			if (temp.getReplyId() != null) {
				Query query2 = session
						.createQuery("from ArticleReply as u where (u.replyId=:tempId or u.id=:tempId) and u.id<:zanId");
				query2.setInteger("tempId", temp.getReplyId());
				query2.setInteger("zanId", temp.getId());
				List<ArticleReply> result2 = query2.list();
				List<ArticleMessages> list2 = new ArrayList<ArticleMessages>();
				for (int i = 0; i < result2.size(); i++) {
					ArticleMessages tempMess2 = new ArticleMessages(result2.get(i).getId(),result2.get(i).getArticle().getId(), result2.get(i).getSender(),
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
   //更新博文
	public void update(Article article) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(article);

	}
	 public void updateStatus(int id) throws Exception{
		 Session session = sessionFactory.getCurrentSession();
		 ArticleReply  articleReply = (ArticleReply)session.get(ArticleReply.class,id);
		 articleReply.setStatus(1);
		 session.update(articleReply);
	 }
	public void addArticleReply(ArticleReply articleReply) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		session.save(articleReply);
	}
	@Override
	public void select(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	public void delete(Article article) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(article);
	}
	
	public void deleteArticleReply(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		ArticleReply  mes  = (ArticleReply)session.get(ArticleReply.class,id);
		if(mes.getReplyId()==null){
			Query query = session.createQuery("from ArticleReply  as  u where u.replyId=:tempReplyId");
			query.setInteger("tempReplyId", id);
			List<ArticleReply> result = query.list();
			for (ArticleReply temp : result) {
				session.delete(temp);
			}
		}
		else{
			Query query = session.createQuery("from ArticleReply as  u where u.replyId=:tempReplyId and u.id>:tempId");
			int tempReplyId = mes.getReplyId();
			query.setInteger("tempReplyId", tempReplyId);
			query.setInteger("tempId", id);
			List<Message> result = query.list();
			for (Message temp : result) {
				session.delete(temp);
			}
		}
		session.delete(mes);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	 @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
