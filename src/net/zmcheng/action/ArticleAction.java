package net.zmcheng.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Article;
import net.zmcheng.model.User;
import net.zmcheng.service.articleService;

@SuppressWarnings("serial")
public class ArticleAction extends ActionSupport implements ModelDriven<Article> ,Serializable,ServletRequestAware{

	private Article article = new Article();
	private HttpServletRequest request;
	private articleService articleServiceImpl;
	private String result;
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	public User getSessionUser() throws Exception{
		 HttpSession httpSession = request.getSession(false);
	     User user2 = (User)httpSession.getAttribute("user");
	     return user2;
	}
    //写博文
    public String write() throws Exception{
    	article.setUser(this.getSessionUser());
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
