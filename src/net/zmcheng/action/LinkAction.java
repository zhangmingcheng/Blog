package net.zmcheng.action;

import java.io.Serializable;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Link;
import net.zmcheng.service.linkService;
import net.zmcheng.tool.MyDate;
import net.zmcheng.tool.Paging;

@SuppressWarnings("serial")
public class LinkAction extends  ActionSupport implements Serializable , ModelDriven<Paging>{
	
	private List<Link> list;//要返回的某一页的记录
	private int id;
	private String name;
	private String url;
	private Paging paging = new Paging();
	private linkService linkServiceImpl;
	private String result;
	public Paging getModel(){
		return paging;
	}
	//得到指定页数的数据
	 public String execute() throws Exception{
		   this.getLists();
		   return SUCCESS;
	   }
	 public void getLists() throws Exception{
		  int len = linkServiceImpl.getAllLink();
		   int totalpage = paging.countTotalPage(len);
		   paging.setAllRow(len);
		   paging.setTotalPage(totalpage);
		   int start =paging.countOffset();
		   list =  linkServiceImpl.selectAllLink(start, Paging.getPageSize());
	 }
	 public String allFriend() throws Exception{
		 this.getLists();
		 return SUCCESS;
	 }
	 public String add() throws Exception{
		 if(this.getName().equals("")||this.getUrl().equals("")){
			 this.getLists();
			 this.result = "友链名称及友链URL不能为空，请您重新输入。";	 
					 return SUCCESS;
		 }
		 Link link = new Link(this.getName(),this.getUrl(),MyDate.getTime());
		 linkServiceImpl.add(link);
		 this.getLists();
		 this.result = "添加成功";
		 return SUCCESS;
	 }
	 public String update() throws Exception{
		  Link link =  linkServiceImpl.getLink(this.getId());
		  this.setName(link.getName());
		  this.setUrl(link.getUrl());
		 return SUCCESS;
	 }
	 public String update2() throws Exception{
		 if(this.getName().equals("")||this.getUrl().equals("")){
			 this.result = "友链名称及友链URL不能为空，请您重新输入。";	 
					 return SUCCESS;
		 }
		 Link link = linkServiceImpl.getLink(this.getId());
		 link.setName(this.getName());
		 link.setUrl(this.getUrl());
		 linkServiceImpl.update(link);
		 this.result = "修改友链成功";
		 return SUCCESS;
	 }
	//删除指定友情链接
	 public String delete() throws Exception{
		 Link link = new Link();
		 link.setId(this.id);
		 linkServiceImpl.delete(link);
		 //判断删除友链后应拿到哪一页的数据
		  int flag = paging.JudgePage(linkServiceImpl.getArticleNum(id));
		  paging.setCurrentPage(flag);
		   int len =  linkServiceImpl.getAllLink();
		   int totalpage = paging.countTotalPage(len);
		   paging.setAllRow(len);
		   paging.setTotalPage(totalpage);
		   int start =paging.countOffset();
		   list = linkServiceImpl.selectAllLink(start, Paging.getPageSize());
		 return SUCCESS;
	 }
	  public List<Link> getList() {
			return list;
		}
		public void setList(List<Link> list) {
			this.list = list;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public linkService getLinkServiceImpl() {
			return linkServiceImpl;
		}
		public void setLinkServiceImpl(linkService linkServiceImpl) {
			this.linkServiceImpl = linkServiceImpl;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
}