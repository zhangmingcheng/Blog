package net.zmcheng.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Article;
import net.zmcheng.model.ArticleMessages;
import net.zmcheng.model.Type;
import net.zmcheng.model.User;
import net.zmcheng.service.articleService;
import net.zmcheng.service.typeService;
import net.zmcheng.tool.MyDate;
import net.zmcheng.tool.Paging;

@SuppressWarnings("serial")
public class ArticleAction extends ActionSupport implements ModelDriven<Article> ,Serializable,ServletRequestAware{

	private Article article = new Article();
	private List<ArticleMessages> list = new ArrayList<ArticleMessages>();
	private List<Type> list2 = new ArrayList<Type>();
	private int types;
	private String typesValue;
	private HttpServletRequest request;
	private articleService articleServiceImpl;
	private typeService typeServiceImpl;
	private int articleReplyNum;
	private int zanCount;
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
    	article.setZanNum(0);
    	article.setReadNum(0);
    	article.setPostdate(MyDate.getTime());
    	 if(types!=0){
      	    Type type = typeServiceImpl.getType(types);
      	    article.setType(type);
      	   }
    	articleServiceImpl.write(article);
   	    request.setAttribute("articleId", article.getId());
    	return SUCCESS;
    }
    //编辑指定博文,为指定博文传入之前存的内容
    public String edit() throws Exception{
    	Article article2 = articleServiceImpl.getArticle(article.getId());
    	article.setContent(article2.getContent());
    	article.setTitle(article2.getTitle());
    	article.setBrief(article2.getBrief());
    	if(article2.getType()!=null){
    		this.setTypes(article2.getType().getId());
        	this.setTypesValue(article2.getType().getName());
    	}
    	list =  articleServiceImpl.getAllArticleMessage(article.getId());
    	list2 = typeServiceImpl.selectAllType(0,Paging.getPageSize());
    	return SUCCESS;
    }
    //编辑指定博文，更新博文
    public String edit2() throws Exception{
    	Article article2 = articleServiceImpl.getArticle(article.getId());
        request.setAttribute("articleId", article.getId());
    	article2.setContent(article.getContent());
    	article2.setTitle(article.getTitle());
    	article2.setBrief(article.getBrief());
    	if(types!=0){
      	    Type type = typeServiceImpl.getType(types);
      	    article2.setType(type);
      	   }
    	articleServiceImpl.update(article2);
    	return SUCCESS;
    }
    //打开博文
    public String open() throws Exception{
        Article article2 = articleServiceImpl.getArticle(article.getId());
        article.setContent(article2.getContent());
        article.setTitle(article2.getTitle());
        article.setZanNum(article2.getZanNum());
        article.setPostdate(article2.getPostdate());
        article.setReadNum(article2.getReadNum()+1);
        article2.setReadNum(article2.getReadNum()+1);
        if(article2.getType()!=null){
        	types =1;
        	typesValue=article2.getType().getName();
        }
        articleServiceImpl.update(article2);
        article.setUser(article2.getUser());
        list =  articleServiceImpl.getAllArticleMessage(article.getId());
    	return SUCCESS;
    }
   //修改赞数,并得到赞数
    public String getZan()  throws Exception{
    	 Article article2 = articleServiceImpl.getArticle(article.getId());
    	 zanCount=article2.getZanNum()+1;
    	 article2.setZanNum(article2.getZanNum()+1);
    	 articleServiceImpl.update(article2);
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
	public int getZanCount() {
		return zanCount;
	}
	public void setZanCount(int zanCount) {
		this.zanCount = zanCount;
	}
	public int getArticleReplyNum() {
		return articleReplyNum;
	}
	public void setArticleReplyNum(int articleReplyNum) {
		this.articleReplyNum = articleReplyNum;
	}
	public int getTypes() {
		return types;
	}
	public void setTypes(int types) {
		this.types = types;
	}
	public List<ArticleMessages> getList() {
		return list;
	}
	public void setList(List<ArticleMessages> list) {
		this.list = list;
	}
	public typeService getTypeServiceImpl() {
		return typeServiceImpl;
	}
	public void setTypeServiceImpl(typeService typeServiceImpl) {
		this.typeServiceImpl = typeServiceImpl;
	}
	public List<Type> getList2() {
		return list2;
	}
	public void setList2(List<Type> list2) {
		this.list2 = list2;
	}
	public String getTypesValue() {
		return typesValue;
	}
	public void setTypesValue(String typesValue) {
		this.typesValue = typesValue;
	}
}
