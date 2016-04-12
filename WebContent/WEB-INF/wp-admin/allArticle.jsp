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
  <body>

    <%@ include file="head.jsp" %> 
      <div class="container">
		<div class="row">
			<!-- 左半部分 -->
			<div class="col-md-3">
				<div style="height: 260px; margin-top: 10px;">
					<s:if test="%{#session.user.photo==null}">
						<img class="img-circle" title="用户头像"
							style="height: 240px; width: 90%;"
							src="<%=path%>/images/default.jpg">
					</s:if>
					<s:else>
						<!-- 浏览器解析html时，只要发现存在一个img标签，便会向服务器要图片，所以要解决缓存 -->
						<img class="img-circle" title="用户头像"
							style="height: 240px; width: 90%;"
							src="<%=path%>/images/${user.name}/${user.photo}?temp=<%=Math.random()%>">
					</s:else>
				</div>
				<div>
				  <table class="table table-hover">			
					<tr class="success"><th style="width: 80px"><a style="margin-left: 20%; margin-buttom: 10px;"
						href="/Blog/wp-admin/userInformation">个人主页</a></th></tr><tr class="success"><th> <a
						style="margin-left: 20%; margin-buttom: 10px;" href="/Blog/wp-admin/writeArticle">写文章</a></th></tr><tr class="success"><th>
					<a style="margin-left: 20%; margin-buttom: 10px;" href="#">留言板</a></th></tr>
					</table>
				</div>
			</div>
			<!-- 右半部分 -->
			<div class="col-md-9">
			
                   <table class="table table-hover table-bordered">
                   <tr style="height:30px">
                       <th>标题</th><th>作者</th><th>日期</th><th></th><th></th>
                   </tr>              
                    <s:iterator value="list"  id="selectNum1">                
                        <tr style="height:60px">
                        <td>${selectNum1.getTitle()}</td>
                        <td>${selectNum1.getUser().getName()}</td>
                         <td>${selectNum1.getPostdate()}</td>
                         <td><button type="button" class="btn btn-info">（一般信息）Info</button></td>
                         <td><button type="button" class="btn btn-info">（一般信息）Info</button></td>
                        </tr>
                 </s:iterator>        
                 </table>
                 <nav>
                         <ul class="pager">
                         <s:if test="currentPage ==1">  
                            <li>Previous></li>
                          </s:if>
                          <s:else>
                             <li><a href="/Blog/text/articles?currentPage=<s:property value="currentPage-1"/>">Previous></a></li>
                          </s:else>
                           <s:if test="currentPage !=totalPage">  
                                Next
                           </s:if>
                           <s:else>
                              <li><a href="/Blog/text/articles?currentPage=<s:property value="currentPage+1"/>">Next</a></li>
                           </s:else>
                          </ul>
                </nav>              
                    
		</div>
	   </div>
	 </div>

    <footer class="blog-footer">
        <p>
		      Blog template built by <a href="https://www.zmcheng.net">@zmcheng</a>.
	    </p>
    </footer>
  </body>
</html>