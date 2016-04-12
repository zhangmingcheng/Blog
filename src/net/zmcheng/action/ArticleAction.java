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
   	    HttpSession httpSession = request.getSession(false);
   	    httpSession.setAttribute("articleId", article.getId());
    	return SUCCESS;
    }
    //打开博文
    public String open() throws Exception{
        Article article2 = articleServiceImpl.getArticle(article.getId());
        article.setContent(article2.getContent());
        article.setTitle(article2.getTitle());
        article.setPostdate(article2.getPostdate());
        article.setReadNum(article2.getReadNum()+1);
        article.setUser(article2.getUser());
        articleServiceImpl.update(article);
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
