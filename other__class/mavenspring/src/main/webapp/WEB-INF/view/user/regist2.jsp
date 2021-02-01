<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post"> 
		<input type="text" name="userid" placeholder="입력하신 아이디"/>
		<input type="text" name="pw" placeholder="입력하신 비밀번호"/>
		<input type="text" name="pwcheck" placeholder="입력하신 비밀번호 체크"/>
		<input type="text" name="name" placeholder="입력하신 이름"/>
		<input type="text" name="email" placeholder="입력하신 이메일"/>
		
		<input type="submit" value="전송"/>	
	</form>
</body>
</html>
