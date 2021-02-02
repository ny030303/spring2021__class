<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if(session.getAttribute("isLogin") != null) {
	boolean isLogin = (boolean) session.getAttribute("isLogin");
		if(!isLogin) {
%>		<script type="text/javascript"> alert("로그인 실패!");</script>
<%		session.removeAttribute("isLogin");
		}
	} 
%>

<!-- 
<script type="text/javascript">
let isLogin = '${isLogin}';
if(isLogin == 'false') {
	alert("로그인 실패!");	
}
</script>
 -->

	<h1>로그인 페이지</h1>
	<form method="post">
		<input type="text" name="userid"/><br/>
		<input type="password" name="password"/><br/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>
