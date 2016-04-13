package net.zmcheng.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.zmcheng.dao.articleDao;
import net.zmcheng.model.Article;
import net.zmcheng.service.articleService;
@Component
public class articleServiceImpl implements articleService {
	private articleDao articleDaoImpl;
	//分页查询数据setFirstResult(start)中索引start是从0开始的
  	public List<Article> getArticles(final int start,final int  length) throws Exception{
  		return articleDaoImpl.getArticles(start, length);
  	}
  	public int getArticleNum(int id) throws Exception{
  		return articleDaoImpl.getArticleNum(id);
  	}
  //得到所有博文
  	public int getAllArticle() throws Exception{
  		return articleDaoImpl.getAllArticle();
  	}
	//写博文
	public void write(Article article) throws Exception {
		articleDaoImpl.write(article);
	}
  //得到指定博文
	public Article getArticle(int id) throws Exception{
		return articleDaoImpl.getArticle(id);
	}
	//删除指定博文
	public void delete(Article article) throws Exception {
		articleDaoImpl.delete(article);
	}
   
	//更新博文
	public void update(Article article) throws Exception {
		articleDaoImpl.update(article);
	}

	@Override
	public void select(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	public articleDao getArticleDaoImpl() {
		return articleDaoImpl;
	}
	 @Resource
	public void setArticleDaoImpl(articleDao articleDaoImpl) {
		this.articleDaoImpl = articleDaoImpl;
	}

}
