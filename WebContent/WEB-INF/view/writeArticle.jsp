 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人博客--代码改变世界</title>
<%
	String path = request.getContextPath();
%>
<link href="<%=path%>/css/blog.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/ueditor/themes/default/css/ueditor.min.css" rel="stylesheet" type="text/css" />
 <!-- 配置文件 -->
<script src="<%=path %>/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script src="<%=path %>/ueditor/ueditor.all.min.js"></script>
<script charset="utf-8" src="<%=path %>/js/baiduUE/zh-cn.js"></script>
<style type="text/css">
 div{
   width:100%;
 }
</style>
</head>

<body>
     <%@ include file="head.jsp" %> 
 <div class="container">
		<div class="row" style="height: 600px">
			<!-- 左半部分 -->
			<div class="col-md-9">
			<div class="main" style="margin: 20px 0px;">
	       <form method="post" action="/myWorld/add.action" onsubmit="return checkArt()">
		      标题：<input class="title_input" type="text" name="article.articleTitle" id="articleTitle" onblur="titleNotNull()"><span id="tipsTitle" style="color: red;font-weight:bolder;"></span>
		    <br>
		    分类：<select class="title_input" name="category.id">
				<option>----选择分类----</option>			
			</select>
		<textarea id="myEditor" style="height:500px;margin: 5px 0px;" name="article.articleContent" onchange="contentNotNull()"></textarea>
		<div class="left">
			<input type="submit" value="提交" class="sub_btn">
			<input type="reset" value="重置" class="reset_btn" onclick="setContentNull()">
		</div>
	</form>
	</div>
			 <script type="text/javascript">
                    var editor =  new baidu.editor.ui.Editor();
                    editor.render("myEditor");
              </script>
			</div>
			<!-- 右半部分 -->
			<div class="col-md-3" style="background-color: green;height:600px" >
			   sssss
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