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
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<title>입주민 목록</title>
	 <link href="MainBootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="MainBootstrap/css/heroic-features.css" rel="stylesheet">


</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="presidentMain.jsp">ARMS</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="userInfoDetailView.jsp">나의정보보기</a>
                    </li>
                    <li>
						<a href="logout.arms">로그아웃</a>
                    		
                    </li>
                    <li>
						<a href="residentMange.arms">입주민목록</a>
                    		
                    </li>
                    <li>
                        <a href="#">채팅방</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

	<h2>입주민 목록 보기</h2>
	<%if(residentList == null){
		%>
				<h2>등록된 입주민이 없습니다.</h2>
				
	<%}
	else{
	%>	
		<table width="800" border="1" cellspacing = "0">
			<tr>
			
			<td>ID</td>
			<td>이름</td>
			<td>동</td>
			<td>호</td>
			<td>전화번호</td>
			<td>보유차량대수</td>
			<td>반상회장여부</td>
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
				<td><%=residentList.get(i).getU_hostId() %></td>
				<td><a href = "deleteResident.arms?id=<%=residentList.get(i).getU_id() %>"><input type = "submit" value = "삭제"></a></td>
				<td>
				<a href = "modifyHostId.arms?hostId=<%=residentList.get(i).getU_id() %>"><input type = "submit" value = "부여"></a>
				<a href = "deleteyHostId.arms?hostId=<%=residentList.get(i).getU_id() %>"><input type = "submit" value = "회수"></a>
				</td>	
				
				</tr>	
			
			
			<%} %>
			
	<%
	}
	%>
	
		</table>
	

</body>
</html>