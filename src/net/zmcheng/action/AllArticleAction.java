package net.zmcheng.action;

import java.io.Serializable;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Article;
import net.zmcheng.tool.Paging;

@SuppressWarnings("serial")
public class AllArticleAction extends  ActionSupport implements Serializable , ModelDriven<Paging>{
	
		private List<Article> list;//要返回的某一页的记录
		private Paging paging = new Paging();
		public Paging getModel(){
			return paging;
		}
		 public String execute() throws Exception{
			  /* pageDAO pagedao = new pageDAOlmpl();
			   String sql = "from NlUser";
			   int len = pagedao.getAllRowCount(sql);
			   int totalpage = paging.countTotalPage(len);
			   paging.setTotalPage(totalpage);
			   paging.setAllRow(len);
			   int start =paging.countOffset();
			   list =  pagedao.queryNewPage(sql,start,Paging.getPageSize());*/
			   return SUCCESS;
		   }
		
		  public List<Article> getList() {
				return list;
			}
			public void setList(List<Article> list) {
				this.list = list;
			}
	}