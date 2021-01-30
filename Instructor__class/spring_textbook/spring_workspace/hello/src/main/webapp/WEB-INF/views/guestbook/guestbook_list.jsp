<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

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
  
  <form name="form">
	<input type="hidden" name="pg" value="">
	<input type="hidden" name="sel" id="sel" value="" />  	
  	
  <div class="input-group mt-3 mb-3">
  <div class="input-group-prepend">
    <button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" 
        id="searchItem">
     	  전체
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#" onclick="changeSearch('1')">전체</a>
      <a class="dropdown-item" href="#" onclick="changeSearch('2')">제목</a>
      <a class="dropdown-item" href="#" onclick="changeSearch('3')">내용</a>
      <a class="dropdown-item" href="#" onclick="changeSearch('4')">제목 + 내용</a>
    </div>
  </div>
  <input type="text" class="form-control" name="key" id="key" value="" placeholder="검색어를 입력하ㅔ요">
  <div class="input-group-append">
    <button class="btn btn-success" type="button" onclick="goSearch()">Go</button>
  </div>
</div>


  <table class="table" id="mytable">
  	<colgroup>
  		<col width="8%"/>
  		<col width="*">
  		<col width="16%"/>
  		<col width="16%"/>
  	</colgroup>
    <thead class="table-primary">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody >
    </tbody>
  </table>

	<div class="container" style="text-align:right">
	  <div class="btn-group">
	    <button type="button" class="btn btn-primary" onclick="goWrite()" >글쓰기</button>
	  </div>
	</div>

</form>
</div>
</body>
</html>

<script >
$(document).ready(function(){
	
	//ajax를 사용해서 디비 데이터 가져오기
	 $.ajax({
		url:"/myapp/guestbook/listjson",
		data:{},
		dataType:"json"
	 }).done( 
		function(response){
			console.log(response);
			//성공시 응답 
			response.forEach( function(e){
						
			 var contents = "<tr>" +
				"<td>" + e.id + "</td>" + 
				"<td><a href='/myapp/guestbook/view/"+ e.id +"'>" + e.title + "</a></td>" + 
				"<td>" + e.writer + "</td>" + 
				"<td>" + e.wdate + "</td>" 
			   + "/<tr>";
					
				$('#mytable > tbody:last').append(contents);
			})
		} 
	 ).fail( function(jqXHR, textStatus){
		console.log( jqXHR + textStatus);
		//에러메시지
	 });
});

function goWrite(){
	var frm = document.form;
	frm.method="get";
	frm.action="/myapp/guestbook/write";
	frm.submit();
}

</script>




















