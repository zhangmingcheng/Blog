package net.zmcheng.dao;

import java.util.List;

import net.zmcheng.model.Article;
import net.zmcheng.model.ArticleMessages;
import net.zmcheng.model.ArticleReply;

public interface articleDao {
    public void write(Article article) throws Exception;
    public void update(Article article) throws Exception;
    public void updateStatus(int id) throws Exception;
    public void select(Article article) throws Exception;
    public void delete(Article article) throws Exception;
    public void deleteArticleReply(int id) throws Exception;
    public int getArticleMessageNum(int id) throws Exception;
    public Article getArticle(int id) throws Exception;
    public List<ArticleMessages> getAllArticleMessage(int id) throws Exception;
  //分页查询数据setFirstResult(start)中索引start是从0开始的
  	public List<Article> getArticles(final int start,final int  length) throws Exception;
  //得到所有博文
  	public int getAllArticle() throws Exception;
  	public List<Article> getALLArticle() throws Exception;
	public int getArticleNum(int id) throws Exception;
	public void addArticleReply(ArticleReply articleReply) throws Exception;
	public List<Article> getKeyArticles(String keyWord) throws Exception;
	public List<Article> getHotArticle() throws Exception;
	public List<Article> getTypeArticles(int id) throws Exception;
}
