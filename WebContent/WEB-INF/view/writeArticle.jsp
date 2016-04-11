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
 <!-- 配置文件 -->
<script src="<%=path %>/js/baiduUE/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script src="<%=path %>/js/baiduUE/ueditor.all.min.js"></script>
<script charset="utf-8" src="<%=path %>/js/baiduUE/zh-cn.js"></script>
<style type="text/css">
 div{
   width:100%;
 }
</style>
</head>

<body>
     <%@ include file="head.jsp" %> 
 
	<h1>完整demo</h1>

       
     <textarea name="content" id="content" style="height:250px">这里是内容</textarea>
     <!-- 实例化编辑器 -->
<script type="text/javascript">
    UE.getEditor('content');
</script>
     
     <footer class="blog-footer">
	<p>
		Blog template built by <a href="https://www.zmcheng.net">@zmcheng</a>.
	</p>
	</footer>
</body>
</html>