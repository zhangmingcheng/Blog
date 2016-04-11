package net.zmcheng.service;

import net.zmcheng.model.Article;

public interface articleService {
    public void write(Article article) throws Exception;
    public void delete(Article article) throws Exception;
    public void update(Article article) throws Exception;
    public void select(Article article) throws Exception;
}
