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

        <div class="col-sm-8 blog-main"  style="border: 1px solid #00F"  style="clear: both">
        
                <form action="/Blog/user/uploadphotoaction" method="post" enctype="multipart/form-data"  >
						<table width="100%" border="0" cellspacing="1" cellpadding="10" > 
								<tr >
									<td width="40%" >&nbsp;
										<h4 >当前头像</h4>
								  </td>
									<td>&nbsp;
									    <h4>上传头像 </h4>
									</td>
								</tr>
								<tr>
								    <td>&nbsp;							       
											 <s:if test="%{#session.user.photo==null}">								
                                                    <img   style="height: 150px; width: 200px; margin-bottom: 1%" src="<%=path%>/images/default.jpg">
                                            </s:if>
                                         <s:else>
                                                    <!-- 浏览器解析html时，只要发现存在一个img标签，便会向服务器要图片，所以要解决缓存 -->
                                                   <img   style="height: 150px; width: 200px; margin-bottom: 1%" src="<%=path%>/images/${user.name}/${user.photo}?temp=<%=Math.random()%>">
                                         </s:else>
									</td>
									<td valign="top">&nbsp;	
									    <input type="file" name="upload" /><br /> &nbsp;
									    <font>支持 JPG、JPEG、GIF、BMP 和 PNG文件格式，最大4M。 头像高度超出宽度1.5倍的部分会被切除。</font><br /><br />
									     <input type="submit" value="上传头像" class="sub" style="margin-bottom: 1%" />
									      <s:property value="result"/>
									</td>
								</tr>
							</table>
					</form>
									

                
                
                
                
                
                
                
                
                
                
                
                
                
                
                <!-- 
              <s:form action="uploadphotoaction" namespace="/user" enctype="multipart/form-data">
     	       	    <s:file label="选择文件：" name="upload" />
     		        <s:submit value="上传头像" />
             </s:form>
             -->
            
        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <li><a href="#">March</a></li>
              <li><a href="#">February </a></li>
              <li><a href="#">January </a></li>
              <li><a href="#">December</a></li>
              <li><a href="#">November </a></li>
              <li><a href="#">October </a></li>
              <li><a href="#">September </a></li>
              <li><a href="#">August </a></li>
              <li><a href="#">July </a></li>
              <li><a href="#">June </a></li>
              <li><a href="#">May </a></li>
              <li><a href="#">April </a></li>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </div><!-- /.container -->

    <footer class="blog-footer">
      <p>Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>

    <script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script src="<%=path %>/js/flog.js"></script>
  </body>
</html>
