<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Vector chat = (Vector)application.getAttribute("chat");
if(chat == null){
	chat = new Vector(100);
}
String name = (String)session.getAttribute("u_name");
String insert = request.getParameter("comment");
if(insert != null && insert.length() > 0){
	if(chat.size() >= 10){
		chat.remove(0);
		insert = name + " : " + insert;
		chat.add(insert);
		application.setAttribute("chat", chat);
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="form1.comment.focus()">
<p>대화 내용 입력 하세요</font></p>

</body>
</html>