<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<div class="container" style="margin-top:20px">
  <h2>게시판 글쓰기</h2>
  <p></p>
  <form name="form" method="post">


  <table class="table">
  	<colgroup>
  		<col width="25%"/>
  		<col width="*"/>
  	</colgroup>
    
    <tbody>
      <tr>
      	<td>제목</td>
        <td>
			  <div class="input-group mb-3">
			    <input type="text" class="form-control" placeholder="제목을 입력하세요" id="title">
			  </div>
  		</td>
     </tr>      
      <tr >
        <td>작성자</td>
        <td>
			  <div class="input-group mb-3">
			    <input type="text" class="form-control" placeholder="이름을 입력하세요" id="writer">
			  </div>
  		</td>
     
      </tr>
      <tr >
        <td>내용</td>
        <td> 
        	<div class="input-group mb-3">
			    <textarea class="form-control" rows="5" id="contents"></textarea>
			</div>
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
	    <button type="button" class="btn btn-primary" onclick="goWrite()">등록</button>&nbsp;&nbsp;
	    <button type="button" class="btn btn-primary" onclick="goCancel()">취소</button>&nbsp;&nbsp;
	  </div>
	</div>
</form>	
</div>

</body>
</html>

<script >
$(document).ready(function(){
})

function goWrite()
{
	var title = $("#title").val();  // input 태그는 val() , 그밖의 태그는 html() 
	var contents = $("#contents").val(); 
	var writer = $("#writer").val(); 
	
	//ajax를 사용해서 디비 데이터 가져오기
	 $.ajax({
		url:"/myapp/guestbook/insertjson",
		data:JSON.stringify({"title":title, "writer":writer, "contents":contents}), //json객체를 문자열로 바꿔서 
		dataType:"json",
		contentType:'application/json',  //json으로 보내고있음을 알리자 
		type:"POST"
	 }).done( 
		function(response){
			alert("등록성공");
			console.log(response);
		} 
	 ).fail( function(jqXHR, textStatus){
		console.log( jqXHR )
		console.log(textStatus);
		//에러메시지
	 });
}

</script>

