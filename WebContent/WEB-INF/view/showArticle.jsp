
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
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="<%=path %>/js/prototype.js"></script>
<script src="<%=path %>/js/UpdateUserAjax.js"></script>
</head>

<body>
	<%@ include file="head.jsp"%>
	<div class="container">
		<div class="row">
			<!-- 左半部分 -->
			<div class="col-md-9">
			   <div style="height:40px;width: 100%;text-align:center;">
			       <h3>${title}</h3>
			       <h5>${user.getName()}&nbsp;&nbsp;阅读（${readNum}）</h5>
			   </div>
			   <HR size=2><!-- 一条线 -->
			   <div>
			       ${content}
			   </div>
			   <div style="background-color: #F0F0F0;text-align: center;">
			     未经允许不得转载
			   </div>
			   <button id="ZAN" style="margin-top: 20px;margin-left: 45%"type="button" class="btn btn-info glyphicon glyphicon-thumbs-up"  onClick="UpdateZan(${id});">&nbsp;赞(${zanNum})</button>
			</div>
			<!-- 右半部分 -->
			<div class="col-md-3" style="background-color: green; height: 600px">
				sssss</div>
		</div>
	</div>

	<footer class="blog-footer">
	<p>
		Blog template built by <a href="https://www.zmcheng.net">@zmcheng</a>.
	</p>
	</footer>
</body>
</html>