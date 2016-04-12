<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	Vector chat = (Vector)application.getAttribute("chat"); 
 if(chat == null){
	 chat = new Vector(10);
 }
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1" width = "100" height = "100">
<tr height = 10>
<td><center>채팅창</center></td>
<td><center>참가자</center></td>
</tr>
<tr>
<td width="60">
<%
String line;
for(int i =0; i<chat.size(); i++){
	line = (String)chat.elementAt(i);
	out.println(line + "<br>");
}
%>
</td>
<td>
<%

%>
</td>
</tr>
</table>
</body>
</html>