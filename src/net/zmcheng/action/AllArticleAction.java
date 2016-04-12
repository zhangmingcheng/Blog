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
		private Paging paging = new Paging();
		private articleService articleServiceImpl;
		public Paging getModel(){
			return paging;
		}
		//得到指定页数的数据
		 public String execute() throws Exception{
			 System.out.println("当前页=="+paging.getCurrentPage());
			   int len = articleServiceImpl.getAllArticle();
			   int totalpage = paging.countTotalPage(len);
			   paging.setTotalPage(totalpage);
			   paging.setAllRow(len);
			   //计算当前页开始的数据
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
	}