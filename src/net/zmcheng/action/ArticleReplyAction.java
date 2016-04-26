package net.zmcheng.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Article;
import net.zmcheng.model.ArticleMessages;
import net.zmcheng.model.ArticleReply;
import net.zmcheng.service.articleService;
import net.zmcheng.tool.MyDate;

@SuppressWarnings("serial")
public class ArticleReplyAction extends ActionSupport implements ModelDriven<ArticleReply> ,Serializable{

	private ArticleReply articleReply = new ArticleReply();
	private List<ArticleMessages> list = new ArrayList<ArticleMessages>();
	private articleService articleServiceImpl;
	private int 	articleId;
    //写博文评论
    public String addArticleReply() throws Exception{
    	if(articleReply.getContent().equals("")||articleReply.getSender().equals("")){
         list =  articleServiceImpl.getAllArticleMessage(articleId);
    		return SUCCESS;
    	}
    	Article article = articleServiceImpl.getArticle(this.articleId);
    	articleReply.setTime(MyDate.getTime());
    	articleReply.setArticle(article);
    	articleServiceImpl.addArticleReply(articleReply);
       list =  articleServiceImpl.getAllArticleMessage(articleId);
    	return SUCCESS;
    }
  //更改评论状态（是否已阅读）
    public String statusArticleMessage() throws Exception{
    	articleServiceImpl.updateStatus(articleReply.getId());
    	list =  articleServiceImpl.getAllArticleMessage(articleId);
    	return SUCCESS;
    }
    //删除评论
    public String  deleteArticleMessage() throws Exception{
    	System.out.println("=====================");
    	articleServiceImpl.deleteArticleReply(articleReply.getId());
    
    	list =  articleServiceImpl.getAllArticleMessage(articleId);
    	return SUCCESS;
    }
    public ArticleReply getModel(){
		return articleReply;
	}

	public articleService getArticleServiceImpl() {
		return articleServiceImpl;
	}

	public void setArticleServiceImpl(articleService articleServiceImpl) {
		this.articleServiceImpl = articleServiceImpl;
	}


	public int getArticleId() {
		return articleId;
	}


	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public List<ArticleMessages> getList() {
		return list;
	}


	public void setList(List<ArticleMessages> list) {
		this.list = list;
	}


}
