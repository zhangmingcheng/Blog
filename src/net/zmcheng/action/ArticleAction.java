package net.zmcheng.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Article;
import net.zmcheng.service.articleService;

@SuppressWarnings("serial")
public class ArticleAction extends ActionSupport implements ModelDriven<Article> ,Serializable,ServletRequestAware{

	private Article article = new Article();
	private HttpServletRequest request;
	private articleService articleServiceImpl;
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
    //写博文
    public String write() throws Exception{
    	System.out.println("村文章");
    	articleServiceImpl.write(article);
    	return SUCCESS;
    }
    public Article getModel(){
		return article;
	}

	public articleService getArticleServiceImpl() {
		return articleServiceImpl;
	}

	public void setArticleServiceImpl(articleService articleServiceImpl) {
		this.articleServiceImpl = articleServiceImpl;
	}
}
