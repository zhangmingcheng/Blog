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
             <div class="col-md-11" style="margin-left: 3%;background-color: #FFFFFF">
             <h3>文章档案</h3>
             <hr>
                    <s:iterator value="list"  id="selectNum1">                
                      <h5>*&nbsp;${selectNum1.getPostdate()}&nbsp;<a href="/Blog/text/open?id=${selectNum1.getId()}">${selectNum1.getTitle()}</a>&nbsp;${selectNum1.getReadNum()}次浏览</h5>
                 </s:iterator>              
             </div>
        </div>
    </div>
   <br/>
    <div class="blog-footer" style="height: 50px;text-align: center;">
      Blog template built by <a href="https://www.zmcheng.net">@zmcheng</a>.
    </div>

  </body>
</html>