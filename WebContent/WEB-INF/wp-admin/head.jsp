<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="blog-masthead">
		<div class="container">
			<div class="col-md-10">
				<ul class="nav nav-pills">
					<li><a class="blog-nav-item active" href="#">首页</a></li>
					<li><a class="blog-nav-item" href="/Blog/wp-admin/writeArticle">写文章</a></li>
					<li><a class="blog-nav-item" href="#">随便逛逛</a></li>
					<li><a class="blog-nav-item" href="#">文件下载</a></li>
					<li><a class="blog-nav-item" href="#">友情链接</a></li>
					<li><a class="blog-nav-item" href="/Blog/wp-admin/userInformation">个人主页</a></li>
				</ul>
			</div>
			<s:if test="%{#session.user==null}">
				<div class="col-md-1">
					<a class="blog-nav-item" href="/Blog/login">登陆</a>
				</div>
				<div class="col-md-1">
					<a class="blog-nav-item" href="/Blog/register">注册</a>
				</div>
			</s:if>
			<s:else>
				<div class="col-md-1">
					<h4>
						<s:property value="#session.user.getName()" />
					</h4>
				</div>
				<div class="col-md-1">
					<a class="blog-nav-item" href="/Blog/user/quit.action">退出</a>
				</div>
			</s:else>
		</div>
	</div>