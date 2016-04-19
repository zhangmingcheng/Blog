<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ page import="java.util.*" %>
  <%@ page import="net.zmcheng.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人博客--代码改变世界</title>
    <%String path = request.getContextPath(); %>
    <link href="<%=path %>/css/blog.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
    </style>
    <script src="<%=path %>/js/jquery.min.js"></script>
   <script src="<%=path %>/js/bootstrap.min.js"></script>
   <script src="<%=path %>/js/prototype.js"></script>
   <script type="text/javascript">
   function showPopup(IdNum){ 
   var popUp = document.getElementById(IdNum); 
   popUp.style.display="block";
   } 
   function showPopup2(IdNum){ 
	   var popUp = document.getElementById(IdNum); 
	   popUp.style.display="block";
	 } 
   
   function addMessage(){
   	var url = '/Blog/ajax/addMessage.action';
 	var param = Form.serialize('message');
        var myAjax = new Ajax.Request(
            	  url,{method: 'post', parameters: param, onComplete: addMess, asynchronous: true}    	 
            	); 
      }
        function addMess(request){
          var temp = request.responseText.evalJSON();
            
        }  
        
        function replyMessage(IdNum,page){
         	var url = '/Blog/ajax/addReplyMessage.action';
         	var param = Form.serialize('message'+IdNum);
         	param+='&currentPage=';
         	param+=page;
         	param+='&messageId=';
         	param+=IdNum;
         	alert(param);
             var myAjax = new Ajax.Request(
                     url,{method: 'post', parameters: param, onComplete: addReplyMess, asynchronous: true}    	 
                  ); 
        }
        function addReplyMess(request){
            var temp = request.responseText.evalJSON();
       
         }  
   </script>
  </head>
  <body>
 <%@ include file="head.jsp"%>
    <div class="container" >
        <div class="row">
             <div class="col-md-8">
                  <div >
                  <h3 style="text-align: center;">留言板</h3>
                   <form method="post" name="message" id="message">
                      <table style="width:100%">
                          <tr><th><textarea  placeholder="说点什么吧..." class="form-control" rows="3" name="content"></textarea></th></tr>        
                          <tr><th><br/></th></tr>
                          <tr><th>用户名：<input type="text" placeholder="必填" name="sender"></th></tr>            
                          <tr><th><br/></th></tr>
                          <tr><th><button type="button" class="btn btn-success" onClick="addMessage()">提交</button></th></tr>
                       </table>
                   </form>                 
                   </div>  
                     <hr color="black">    
                 <div id="AllMessage">      
                    <s:iterator value="list"  id="selectNum1">      
                        <!-- 留言默认头像 -->            
                         <div style="float: none">     
                                <div style="float:left">                     
                                <img class="img-circle" title="用户头像" style="height: 50px; width: 50px;"src="<%=path%>/images/default.jpg">
                          </div>       
                          <!-- 留言内容区 -->                                                                                         
                          <div style="margin-left:3%">
	                               <h5 style="font-size: 13px;color:blue"> ${selectNum1.getSender()}</h5>
	                             <!-- -->                        
	                            <s:iterator value="#selectNum1.getMessages()"  id="selectNum2">                                                                
	                              <div>
	                                <h5 style="font-size: 13px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#9393FF">${selectNum2.getSender()}</span></h5>                                                          
	                                <h5 style="font-size: 12px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${selectNum2.getContent()}&nbsp;&nbsp;&nbsp;${selectNum2.getTime()}&nbsp;&nbsp;<a href="#" onclick="showPopup2('popupcontent2${selectNum2.getId()}');" >回复</a>&nbsp;&nbsp;</h5>                     
	                                   <!-- 弹框 -->
	                                   <div id="popupcontent2${selectNum2.getId()}" style="display: none">
					                          <form method="post" name="message${selectNum2.getId()}" id="message${selectNum2.getId()}">
					                            <table style="width:100%">
					                               <tr><th><textarea  placeholder="说点什么吧..." class="form-control" rows="2" name="content"></textarea></th></tr>        
					                               <tr><th><br/></th></tr>
					                               <tr><th>用户名：<input type="text" placeholder="必填" name="sender"></th></tr>            
					                               <tr><th><br/></th></tr>
					                              <tr><th><button type="button" class="btn btn-success" onClick="replyMessage('${selectNum2.getId()}','<s:property value="currentPage"/>')">回复</button></th></tr>
					                          </table>
					                        </form>             
					                   </div> 
					                   </div>             
					                   <!--  --> 
	                           </s:iterator>       
	                           <!-- -->
	                             <h5 style="font-size: 13px"> &nbsp;&nbsp;${selectNum1.getContent()}</h5>
	                            <h5 style="font-size: 12px"> ${selectNum1.getTime()}&nbsp;&nbsp;<a href="#" onclick="showPopup('popupcontent${selectNum1.getId()}');" >回复</a></h5>
	                         
                               </div>                  
                        </div>            
                                                 
                        <div id="popupcontent${selectNum1.getId()}" style="display: none">
                         <form method="post" name="message${selectNum1.getId()}" id="message${selectNum1.getId()}">
                            <table style="width:100%">
                               <tr><th><textarea  placeholder="说点什么吧..." class="form-control" rows="2" name="content"></textarea></th></tr>        
                               <tr><th><br/></th></tr>
                               <tr><th>用户名：<input type="text" placeholder="必填" name="sender"></th></tr>            
                               <tr><th><br/></th></tr>
                              <tr><th><button type="button" class="btn btn-success" onClick="replyMessage('${selectNum1.getId()}','<s:property value="currentPage"/>')">回复</button></th></tr>
                          </table>
                        </form>             
                       </div>    
                                                
                       <hr color="black">  
                 </s:iterator>                
                 </div>                       
                 <nav>
                         <ul class="pager">
                         <s:if test="currentPage ==1">  
                            <li><a href="#">Previous</a></li>
                          </s:if>
                          <s:else>
                             <li><a href="/Blog/head/messages?currentPage=<s:property value="currentPage-1"/>">Previous</a></li>
                          </s:else>
                           <s:if test="currentPage !=totalPage">  
                              <li> <a href="/Blog/head/messages?currentPage=<s:property value="currentPage+1"/>">Next</a></li>
                           </s:if>
                           <s:else>
                              <li><a href="#">Next</a></li>
                           </s:else>
                          </ul>
                </nav>              
                
             </div>
             <div class="col-md-4" style="background-color: black; height: 550px">
             
             </div>
        </div>
    </div>

    <div class="blog-footer" style="height: 40px">
      Blog template built by <a href="https://www.zmcheng.net">@zmcheng</a>.
    </div>

  </body>
</html>
