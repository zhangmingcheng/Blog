<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人博客--代码改变世界</title>
    <%String path = request.getContextPath(); %>
    <link href="<%=path %>/css/blog.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  </head>
  <body style="background-color: #E0E0E0">
 <%@ include file="head.jsp"%>
	
    <div class="container" >
        <div class="row">
             <div class="col-md-7" style="margin-left: 3%">
                   
                    <s:iterator value="list"  id="selectNum1">                
                        <div style="background-color: #FFFFFF;magin-top:10px">
                              <div style="margin-left:5%;padding-bottom: 2%">
                                <h5>&nbsp;</h5>
                                 <h4 style="font-weight: bold;color:004B97"><a href="/Blog/text/open?id=${selectNum1.getId()}">${selectNum1.getTitle()}</a></h4>
                                 <h5 style="color:#6C6C6C">${selectNum1.getUser().getName()}&nbsp;发布于&nbsp;${selectNum1.getPostdate()}&nbsp;&nbsp;阅读(${selectNum1.getMessageNum()})&nbsp;&nbsp;
                                 评论(${ selectNum1.getMessageNum()})&nbsp;&nbsp;</h5>
                                 <p>${selectNum1.getBrief() }</p>
                                <h5 style="font-weight: bold;"><a href="/Blog/head/open?id=${selectNum1.getId()}">【查看详情】</a></h5>                
                             </div>
                        </div>
                 </s:iterator>        
             
                 <nav>
                         <ul class="pager">
                         <s:if test="currentPage ==1">  
                            <li><a href="#">Previous</a></li>
                          </s:if>
                          <s:else>
                             <li><a href="/Blog/head/articles?currentPage=<s:property value="currentPage-1"/>">Previous</a></li>
                          </s:else>
                           <s:if test="currentPage !=totalPage">  
                              <li> <a href="/Blog/head/articles?currentPage=<s:property value="currentPage+1"/>">Next</a></li>
                           </s:if>
                           <s:else>
                              <li><a href="#">Next</a></li>
                           </s:else>
                          </ul>
                </nav>              
                    
             </div>
             <div class="col-md-4" style="margin-left:5%;background-color: #FFFFFF;margin-top:10px">
                    <div style="text-align: left;font-weight:bold;font-size: 17px;padding-top: 5px;">关于博客 <hr></div>
                    <div style="font-weight:bold;font-size: 15px;text-align: center;padding-bottom: 5px">张明成的个人博客</div>
                    <div style="margin-left: 1%;margin-right: 1%"><p>本博客是多用户团体博客，用于记录团体的生活、学习和工作中遇到的一些问题和心得。
                       当然，目前此博客只有我在使用，欢迎志趣相投的人加入我的团体，一起使用我的博客系统，我可以告诉您进入后台的地址，
                       另外，本博客中所有内容均为原创，如需转载，请注明出处（<a href="http://www.zmcheng.net">http://www.zmcheng.net</a>）。
                      本人不是大神，但是现在正在向着大神努力，如果您发现博客中有错误或者可以改进的地方，敬请指正！</p></div>
                     <div > <hr></div>
                     <div style="margin-left: 1%;text-align: left;font-weight:bold;font-size: 15px;padding-top: 5px;">
                      联系方式：<br/><br/>
                     <table class="table table-hover">
                        <tr class="warning"><th>QQ: 1249736987</th></tr>
                        <tr class="danger"><th> 邮箱：zmc@zmcheng.net</th></tr>
                        <tr class="info"><th> 微信：1249736988</th></tr>              
                     </table>
                     </div>
             </div>
        </div>
    </div>

    <div class="blog-footer" style="height: 50px;text-align: center;">
      Blog template built by <a href="https://www.zmcheng.net">@zmcheng</a>.
    </div>

  </body>
</html>
