<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ page import="com.mycompany.myhome.freeboard.*" %>
<%@ page import="com.mycompany.myhome.common.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="/sms/list">게시판</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="">상품</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="">Logout</a>
    </li>
    </ul>
</nav>
<%
String id = StringUtil.nullToValue(request.getParameter("id"), "-1");
String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
%>
<div class="container" style="margin-top:20px">
  <h2>게시판 상세보기</h2>
  <p></p>
  <form name="from">
  <input type="hidden" name="id" value="<%=id%>">
   <input type="hidden" name="pg" value="<%=pg%>">
  <table class="table">
  	<colgroup>
  		<col width="25%"/>
  		<col width="*"/>
  	</colgroup>
    
    <tbody>
      <tr>
      	<td>제목</td>
        <td>
			 <c:out value="${freeboardDto.title}" />
  		</td>
     </tr>      
      <tr >
        <td>작성자</td>
        <td>
			<c:out value="${freeboardDto.writer}" />
  		</td>
     
      </tr>
      <tr >
        <td>내용</td>
        <td> 
        	 <c:out value="${freeboardDto.contents}" />
		</td>
      
      </tr>
     
       <tr >
        <td></td>
        <td></td>
      </tr>
      
    </tbody>
  </table>
  
  	<div class="container" style="text-align:right">
	  <div class="btn-group">
	    <button type="button" class="btn btn-primary" onclick="goModify()">수정</button>&nbsp;&nbsp;
	    <button type="button" class="btn btn-danger" onclick="goDelete()">삭제</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-primary" onclick="goList()">목록</button>
	  </div>
	</div>
</form>	
</div>
<script>
function goList()
{
	frm = document.form;
	frm.action="<%=request.getContextPath()%>/freeboard/list";
	frm.submit();
}

function goModify()
{
	frm = document.form;
	frm.action="<%=request.getContextPath()%>/freeboard/modify";
	frm.submit();
}

function goDelete()
{
	if(confirm("삭제하시겠습니까?"))
	{
		frm = document.form;
		frm.action="<%=request.getContextPath()%>/freeboard/delete";
		frm.submit();
	}
	
}
</script>
</body>
</html>