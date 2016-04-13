package net.zmcheng.action;

import java.io.Serializable;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Article;
import net.zmcheng.service.articleService;
import net.zmcheng.tool.Paging;

@SuppressWarnings("serial")
public class AllArticleAction extends  ActionSupport implements Serializable , ModelDriven<Paging>{
	
		private List<Article> list;//要返回的某一页的记录
		private int id;
		private Paging paging = new Paging();
		private articleService articleServiceImpl;
		private String result;
		public Paging getModel(){
			return paging;
		}
		//得到指定页数的数据
		 public String execute() throws Exception{
			   //System.out.println("当前页=="+paging.getCurrentPage());
			   int len = articleServiceImpl.getAllArticle();
			   int totalpage = paging.countTotalPage(len);
			  // System.out.println("总页数=="+totalpage);
			   paging.setAllRow(len);
			   paging.setTotalPage(totalpage);
			   //计算当前页开始的数据
			   int start =paging.countOffset();
			   //System.out.println("start=="+start);
			   list =  articleServiceImpl.getArticles(start, Paging.getPageSize());
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
	}