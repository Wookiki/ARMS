<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#passwdArea{
		margin : auto;
		text-align : center;
		width : 300px;		
		border : 1px dotted red;
		
	}
	h2{
		text-align: center;
	}
	#passwd{
		width : 100px;
	}
	.deleteButton{
		margin : 10px;
	}

</style>
</head>

<body>
<section id = "passwdArea">
	<h2>글삭제</h2>
		
	<form action="boardDeletePro.bo" method = "POST">
	<input type = "hidden" name = "num" value ="${num}"/>
	<input type = "hidden" name = "pageNum" value = "${pageNum}"/>
	<input type = "hidden" name = "bName" value = "${bName}"/>
	<label for = "passwd">비밀번호</label>
	<input type = "password" name = "passwd" id = "passwd"><br>
	<input type = "submit" value = "글삭제" class = "deleteButton">
	</form>
</section>

</body>
</html>