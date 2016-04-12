<%@page import="arms.vo.ActionForward"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String longName = request.getParameter("name");
if(longName !=null && longName.length() > 0)	{
	session.setAttribute("name", longName);
}
String name = (String)session.getAttribute("name");
ActionForward forward  = new ActionForward();
if(name == null){
	forward.setUrl("main.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP CHAT</title>
</head>
<body>

<frameset rows = "*,100">
	<frame src = "view.jsp">
	<frame src = "input.jsp">
</frameset>

</body>
</html>