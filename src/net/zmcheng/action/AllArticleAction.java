package net.zmcheng.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Article;
import net.zmcheng.model.Link;
import net.zmcheng.model.Type;
import net.zmcheng.service.articleService;
import net.zmcheng.service.linkService;
import net.zmcheng.service.typeService;
import net.zmcheng.tool.Paging;

@SuppressWarnings("serial")
public class AllArticleAction extends  ActionSupport implements Serializable , ModelDriven<Paging>{
	
		private List<Article> list;//要返回的某一页的记录
		private List<Article> list2;//热门文章
		private List<Type> list3 = new ArrayList<Type>();
		private List<Link> list4 = new ArrayList<Link>();
		private int id;
		private Paging paging = new Paging();
		private articleService articleServiceImpl;
		private typeService typeServiceImpl;
		private linkService linkServiceImpl;
		private String result;
		private String keyWord;
		public Paging getModel(){
			return paging;
		}
		//文章档案
		public String allArtilces() throws Exception{
			list = articleServiceImpl.getALLArticle();
			return SUCCESS;
		}
		//前端首页
		public String headIndex() throws Exception{
			  int len = articleServiceImpl.getAllArticle();
			   int totalpage = paging.countTotalPage(len);
			   paging.setAllRow(len);
			   paging.setTotalPage(totalpage);
			   int start =paging.countOffset();
			   list =  articleServiceImpl.getArticles(start, Paging.getPageSize());
			   for(Article temp:list){
				   int num =  articleServiceImpl.getArticleMessageNum(temp.getId());
				   temp.setMessageNum(num);
			   }
			   list2 = articleServiceImpl.getHotArticle();
			   list3 = typeServiceImpl.selectAllType(0,Paging.getPageSize());
			   list4 = linkServiceImpl.selectAllLink(0, Paging.getPageSize());
			return SUCCESS;
		}
		//得到指定页数的数据
		 public String execute() throws Exception{
			   int len = articleServiceImpl.getAllArticle();
			   int totalpage = paging.countTotalPage(len);
			   paging.setAllRow(len);
			   paging.setTotalPage(totalpage);
			   int start =paging.countOffset();
			   list =  articleServiceImpl.getArticles(start, Paging.getPageSize());
			   for(Article temp:list){
				   int num =  articleServiceImpl.getArticleMessageNum(temp.getId());
				   temp.setMessageNum(num);
			   }
			   return SUCCESS;
		   }
		 //关键字搜索文章
		 public String keySearch() throws Exception{
			   list =  articleServiceImpl.getKeyArticles(keyWord);
			 return SUCCESS;
		 }
		  //删除指定博文
		 public String delete() throws Exception{
			 Article article2 =  articleServiceImpl.getArticle(id);
			 article2.setUser(null);
			 articleServiceImpl.delete(article2);
			 //判断删除博文后应拿到哪一页的数据
			 int flag = paging.JudgePage(articleServiceImpl.getArticleNum(id));
			 paging.setCurrentPage(flag);
			 
			   int len = articleServiceImpl.getAllArticle();
			   int totalpage = paging.countTotalPage(len);
			   paging.setAllRow(len);
			   paging.setTotalPage(totalpage);
			   int start =paging.countOffset();
			   list =  articleServiceImpl.getArticles(start, Paging.getPageSize());
			 return SUCCESS;
		 }
		  public List<Article> getList() {
				return list;
			}
			public void setList(List<Article> list) {
				this.list = list;
			}
			public articleService getArticleServiceImpl() {
				return articleServiceImpl;
			}

			public void setArticleServiceImpl(articleService articleServiceImpl) {
				this.articleServiceImpl = articleServiceImpl;
			}
			public String getResult() {
				return result;
			}
			public void setResult(String result) {
				this.result = result;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getKeyWord() {
				return keyWord;
			}
			public void setKeyWord(String keyWord) {
				this.keyWord = keyWord;
			}
			public List<Article> getList2() {
				return list2;
			}
			public void setList2(List<Article> list2) {
				this.list2 = list2;
			}
			public List<Type> getList3() {
				return list3;
			}
			public void setList3(List<Type> list3) {
				this.list3 = list3;
			}
			public List<Link> getList4() {
				return list4;
			}
			public void setList4(List<Link> list4) {
				this.list4 = list4;
			}
			public typeService getTypeServiceImpl() {
				return typeServiceImpl;
			}
			public void setTypeServiceImpl(typeService typeServiceImpl) {
				this.typeServiceImpl = typeServiceImpl;
			}
			public linkService getLinkServiceImpl() {
				return linkServiceImpl;
			}
			public void setLinkServiceImpl(linkService linkServiceImpl) {
				this.linkServiceImpl = linkServiceImpl;
			}
	}