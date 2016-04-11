package net.zmcheng.dao;

import net.zmcheng.model.Article;

public interface articleDao {
    public void write(Article article) throws Exception;
    public void update(Article article) throws Exception;
    public void select(Article article) throws Exception;
    public void delete(Article article) throws Exception;
    public Article getArticle(int id) throws Exception;
}
