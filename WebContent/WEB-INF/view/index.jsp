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
 <%@ include file="head.jsp"%>
	
    <div class="container" >
        <div class="row">
             <div class="col-md-7" style="margin-left: 3%; margin-top:1%;background-color: red; height: 550px">
                    
                   <table class="table table-hover table-bordered" id="deleteArt">
                   <tr style="height:30px">
                       <th>标题</th><th>作者</th><th>日期</th><th>编辑</th><th>删除</th>
                   </tr>            
                    <s:iterator value="list"  id="selectNum1">                
                        <tr style="height:50px">
                        <td><a href="/Blog/text/open?id=${selectNum1.getId()}">${selectNum1.getTitle()}</a></td>
                        <td>${selectNum1.getUser().getName()}</td>
                         <td>${selectNum1.getPostdate()}</td>
                         <td><a href="/Blog/text/edit?id=${selectNum1.getId()}"><button type="button" class="btn btn-info">编辑</button></a></td>
                         <td><button type="button" class="btn btn-success" onclick="deleteArticle(${selectNum1.getId()})">删除</button></td>
                        </tr>                      
                 </s:iterator>        
                 </table>
                 <nav>
                         <ul class="pager">
                         <s:if test="currentPage ==1">  
                            <li><a href="#">Previous</a></li>
                          </s:if>
                          <s:else>
                             <li><a href="/Blog/text/articles?currentPage=<s:property value="currentPage-1"/>">Previous</a></li>
                          </s:else>
                           <s:if test="currentPage !=totalPage">  
                              <li> <a href="/Blog/text/articles?currentPage=<s:property value="currentPage+1"/>">Next</a></li>
                           </s:if>
                           <s:else>
                              <li><a href="#">Next</a></li>
                           </s:else>
                          </ul>
                </nav>              
                    
             </div>
             <div class="col-md-4" style="margin-left:5%; margin-top:1%;background-color: black; height: 550px">
             
             </div>
        </div>
    </div>

    <div class="blog-footer" style="height: 40px">
      Blog template built by <a href="https://www.zmcheng.net">@zmcheng</a>.
    </div>

  </body>
</html>
