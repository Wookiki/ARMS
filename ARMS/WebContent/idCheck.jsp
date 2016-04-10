<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean idExists = (boolean)request.getAttribute("idExists");
	String id = (String)request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section{
		margin : auto;
		width : 500px;
		border : 1px solid red;
	}
	h2{
		text-align: center;
	}
</style>
<script>
	function winClose(){
		opener.document.forms[0].id.value = '<%=id%>';
		window.close();
			
	}
</script>
</head>
<body>

<%

if(idExists){
%>
<section>
<h2><%=id %> 는 이미 존재합니다.</h2>
<form action="idCheck.arms?id=">
   아이디 : <input type = "text" name = "id" id = "id"/> <input type = "submit" value = "아이디중복체크"/>
</form>
</section>
<%
}
else{
%>
<section>
	<h2><%=id %> 는 사용 가능한 ID입니다.</h2>
	<a href = "javascript:winClose()">닫기</a>
</section>

<%
}
%>
</body>
</html>








