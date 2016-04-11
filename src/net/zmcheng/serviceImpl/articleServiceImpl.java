package net.zmcheng.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.zmcheng.dao.articleDao;
import net.zmcheng.model.Article;
import net.zmcheng.service.articleService;
@Component
public class articleServiceImpl implements articleService {
	private articleDao articleDaoImpl;
	@Override
	public void write(Article article) throws Exception {
		articleDaoImpl.write(article);
	}

	@Override
	public void delete(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Article article) throws Exception {
		// TODO Auto-generated method stub

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
