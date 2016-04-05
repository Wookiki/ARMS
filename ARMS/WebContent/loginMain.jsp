<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>아파트관리시스템</title>

<style type="text/css">
	h1{
		text-align: center;
	}
	#loginFormArea{
		width : 300px;
		height : 200px;
		margin : auto;
		text-align: center;
		border: 1px solid black;
		border-radius: 10px; 
	}
	h2 {
	text-align: center;
	}
</style>

</head>
<body>
<h1>아파트관리시스템</h1><br>
<section id = "loginFormArea">
	<h2>로그인</h2>
	<form action="login.arms" method = "post">
	<label for = "id">아이디 : </label>
	<input type = "text" name = "id" id = "id"><br>
	<label for = "passwd">비밀번호 : </label>
	<input type = "password" name = "passwd" id = "passwd"><br>
	<input type = "button" value="로그인" onclick ="location='login.arms'">
	</form>
	<form action="join.arms" method = "post">
	<a href = "join.jsp"><input type = "button" value="회원가입"></a>
	</form>
</section>
</body>
</html>