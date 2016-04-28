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
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login">
	<h1>登陆</h1>
	<form method="post"  action="/Blog/user/login.action">
		<input style="background-color: #FFF" type="text" name="name" placeholder="用户名" required="required" />
		<input style="background-color: #FFF" type="password" name="password" placeholder="密码" required="required" />
		<button type="submit" class="btn btn-primary btn-block btn-large">登陆</button>
		<a href="/Blog/wp-admin/register"><button type="button" class="btn btn-success btn-block btn-large">注册</button></a>
      </form>
</div>
</body>
</html>
