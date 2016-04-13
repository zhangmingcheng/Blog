package net.zmcheng.service;

import java.util.List;

import net.zmcheng.model.Article;

public interface articleService {
    public void write(Article article) throws Exception;
    public void delete(Article article) throws Exception;
    public void update(Article article) throws Exception;
    public void select(Article article) throws Exception;
    public Article getArticle(int id) throws Exception;
  //分页查询数据setFirstResult(start)中索引start是从0开始的
  	public List<Article> getArticles(final int start,final int  length) throws Exception;
  //得到所有博文
  	public int getAllArticle() throws Exception;
	public int getArticleNum(int id) throws Exception;
}
