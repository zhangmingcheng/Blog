package net.zmcheng.service;

import java.util.List;

import net.zmcheng.model.Link;

public interface linkService {
	 public void add(Link link) throws Exception;
	    public void delete(Link link) throws Exception;
	    public List<Link> selectAllLink(final int start,final int  length) throws Exception;
	    public void update(Link link) throws Exception;
	    public int getAllLink() throws Exception;
	    public int getArticleNum(int id) throws Exception;
}
