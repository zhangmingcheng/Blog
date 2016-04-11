<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>登陆</title>
<%String path = request.getContextPath(); %>
<link href="<%=path %>/css/normalize.css"  rel="stylesheet" type="text/css"/>
<link href="<%=path %>/css/logincss.css"  rel="stylesheet" type="text/css"/>
<link href="<%=path %>/css/bootstrap.min.css"  rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="login">
	<h1>登陆</h1>
	<form method="post"  action="/Blog/user/login.action">
		<input type="text" name="name" placeholder="用户名" required="required" />
		<input type="password" name="password" placeholder="密码" required="required" />
		<button type="submit" class="btn btn-primary btn-block btn-large">登陆</button>
		<table style=" margin-top: 5px"><tr><th>
		<a href="/Blog/index"><button type="button" class="btn btn-primary">返回后台主页</button></a>
		</th><th style="padding-left: 138px"><a href="/Blog/wp-admin/register"><button   type="button" class="btn btn-primary" >注册</button></a></th></tr>
	   <tr><th></th><th><h5 style="color: red"><s:property value="#request.usererror" /></h5></th></tr></table>
	</form>
</div>
<div style="text-align:center;">
<h2 style="color: blue">个人博客-------代码改变世界</h2>
</div>

</body>

</html>
