<%@page import="arms.web.board.vo.ReplyInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8" >
<title>Insert title here</title>
<style>
	#writeFormArea{
		width:600px;
		height:600px;
		margin : auto;
		border : 1px solid red;
	}
	h2{
		text-align: center;
		border-bottom : 3px double brown;
	}
	table{
		width : 580px;
		margin : auto;
		text-align:center;
	}
	.td_left{
		width : 200px;
	}
	.td_right{
		text-align : left;
		width : 380px;
	}
	#commandCell{
		text-align: center;
	}
</style>
</head>

<body>
	<section id="writeFormArea">
		<h2>글쓰기</h2>
		<form action = "facilityUserWriteProBoard.bo" method = "POST">
		<input type = "hidden" name = "num" value = "${replyInfo.num }"/>
		<input type = "hidden" name = "ref" value = "${replyInfo.ref }"/>
		<input type = "hidden" name = "re_step" value = "${replyInfo.re_step }"/>
		<input type = "hidden" name = "re_level" value = "${replyInfo.re_level }"/>
		<table>
		<tr>
		<td class = "td_left">
		<label for = "writer">작성자 : </label>
		</td>
		<td class = "td_right">		
		<input type = "text" name = "writer
		
		
		
		" id = "writer"
		required = "required">
		</td>		
		</tr>
		<tr>
		<td class = "td_left">
		<label for = "subject">제목 : </label>
		</td>
		<td class = "td_right">	
		<c:if test="${replyInfo.num == 0 }">		
		<input type = "text" name = "subject" id = "subject">
		</c:if>
		<c:if test="${replyInfo.num != 0 }">
			<input type = "text" name = "subject" id = "subject" value = "[답변]">		
		</c:if>
		</td>		
		</tr>		
		<tr>
		<td class = "td_left">
		<label for = "content">글내용 : </label>
		</td>
		<td class = "td_right">		
		<textarea id = "content" name = "content" rows = "13" cols = "40"></textarea>
		</td>		
		</tr>
		<tr>
		<td class = "td_left">
		<label for = "passwd">비밀번호 : </label>
		</td>
		<td class = "td_right">		
		<input type = "password" name = "passwd" id = "passwd">
		</td>		
		</tr>
		<tr>
		<td colspan="2" id = "commandCell">
			<input type = "submit" value = "글등록"/>
			<input type = "reset" value = "다시작성"/>
		</td>
		</table>
		</form>
	</section>
</body>
</html>