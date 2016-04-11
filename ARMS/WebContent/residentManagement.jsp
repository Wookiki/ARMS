<%@page import="arms.web.login.vo.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
/* ArrayList<UserInfo> residentList = (ArrayList<UserInfo>)request.getAttribute("residentList"); */ 
ArrayList<UserInfo>residentList = (ArrayList<UserInfo>)request.getAttribute("residentList");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입주민 목록 보기 <a href = "presidentMain.jsp"><input type = "button" value = "메인으로"></a></h2>
	<%if(residentList.isEmpty()){
		%>
				<h2>등록된 입주민이 없습니다.</h2>
				
	<%}
	else{
	%>	
		<table width="600" border="1" cellspacing = "0">
			<tr>
			
			<td>ID</td>
			<td>이름</td>
			<td>동</td>
			<td>호</td>
			<td>전화번호</td>
			<td>보유차량대수</td>
			<td>삭제</td>
			<td>반상회장</td>
			
			</tr>
			<%for(int i = 0; i<residentList.size(); i++){
				%>				
			<tr>
				<td><%=residentList.get(i).getU_id() %></td>
				<td><%=residentList.get(i).getU_name() %></td>
				<td><%=residentList.get(i).getU_dong() %></td>
				<td><%=residentList.get(i).getU_ho() %></td>
				<td><%=residentList.get(i).getU_tel() %></td>
				<td><%=residentList.get(i).getU_car() %></td>
				<td><a href = "deleteResident.arms?id=<%=residentList.get(i).getU_id() %>"><input type = "submit" value = "삭제"></a></td>
				<td><a href = "grantHostId.arms?id=<%=residentList.get(i).getU_id() %>"><input type = "submit" value = "부여"></a></td>
			</tr>	
			
			
			<%} %>
			
	<%
	}
	%>
	
		</table>
	

</body>
</html>