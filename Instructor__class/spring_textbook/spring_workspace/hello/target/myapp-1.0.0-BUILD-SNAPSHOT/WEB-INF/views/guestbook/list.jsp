<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.mycompany.myapp.guestbook.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<GuestbookDto> list = (List<GuestbookDto>)request.getAttribute("guestbookList");
%>

<table width="80%">
	<%for(int i=0; i<list.size(); i++) {
		GuestbookDto dto=list.get(i);
	%>
	<tr>
		<td><%=dto.getId()%></td>
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getWriter()%></td>
		<td><%=dto.getWdate()%></td>
		<td><%=dto.getContents()%></td>
	<%} %>	
	</tr>
</table>
</body>
</html>