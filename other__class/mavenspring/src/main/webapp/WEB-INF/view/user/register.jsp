<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<%
	if(session.getAttribute("isSignup") != null) {
	String isSignup = "" + session.getAttribute("isSignup");
		if(isSignup.equals("false")) {
%>		<script type="text/javascript"> alert("회원가입 실패!");</script>
<%		session.removeAttribute("isSignup");
		} else if (isSignup.equals("pwError")) {
%> 		<script type="text/javascript"> alert("비밀번호 틀림!");</script>
<%			session.removeAttribute("isSignup");
		}
	} 
%>

<div class="container">
	<div class="form-group">
		<h1>회원가입</h1>
		<form method="post"> 
			<input type="text" class="form-control" name="userid" placeholder="아이디"/><br>
			<input type="text" class="form-control" name="password" placeholder="비밀번호"/><br>
			<input type="text" class="form-control" name="passwordCheck" placeholder="비밀번호 확인"/><br>
			<input type="text" class="form-control" name="username" placeholder="이름"/><br>
			
			<input type="submit" class="btn btn-primary" value="전송"/>	
		</form>
	</div>
</div>

</body>
</html>