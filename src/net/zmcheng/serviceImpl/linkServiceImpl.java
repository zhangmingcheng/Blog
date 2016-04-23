package net.zmcheng.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.zmcheng.dao.linkDao;
import net.zmcheng.model.Link;
import net.zmcheng.service.linkService;
@Component
public class linkServiceImpl implements linkService {
     private linkDao linkDaoImpl;
     public int getAllLink() throws Exception{
    	 return linkDaoImpl.getAllLink();
     }
     public Link getLink(int id) throws Exception{
    	 return linkDaoImpl.getLink(id);
     }
     public int getArticleNum(int id) throws Exception{
    	 return  linkDaoImpl.getArticleNum(id);
     }
	public void add(Link link) throws Exception {
		linkDaoImpl.add(link);
	}

	public void delete(Link link) throws Exception {
		 linkDaoImpl.delete(link);
	}

	public List<Link> selectAllLink(final int start,final int  length) throws Exception {
		return linkDaoImpl.selectAllLink(start, length);
	}

	public void update(Link link) throws Exception {
		linkDaoImpl.update(link);
	}

	public linkDao getLinkDaoImpl() {
		return linkDaoImpl;
	}
    @Resource
	public void setLinkDaoImpl(linkDao linkDaoImpl) {
		this.linkDaoImpl = linkDaoImpl;
	}

}
