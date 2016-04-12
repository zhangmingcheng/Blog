package net.zmcheng.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.zmcheng.dao.articleDao;
import net.zmcheng.model.Article;
import net.zmcheng.service.articleService;
@Component
public class articleServiceImpl implements articleService {
	private articleDao articleDaoImpl;
	//写博文
	public void write(Article article) throws Exception {
		articleDaoImpl.write(article);
	}
  //得到指定博文
	public Article getArticle(int id) throws Exception{
		return articleDaoImpl.getArticle(id);
	}
	@Override
	public void delete(Article article) throws Exception {
		// TODO Auto-generated method stub
		articleDaoImpl.update(article);
	}

	//更新博文
	public void update(Article article) throws Exception {
      
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
