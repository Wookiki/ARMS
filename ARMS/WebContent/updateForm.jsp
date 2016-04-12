<%@page import="arms.web.board.vo.Article"%>
<%@page import="arms.web.board.dao.BoardDAO"%>
<%@page import="arms.web.login.vo.UserInfo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#updateFormArea{
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
	<section id="updateFormArea">
		<h2>글쓰기</h2>
		<form action = "boardUpdatePro.bo" method = "POST">
		<input type = "hidden" name = "num" value="${article.num }"/>		
		<input type = "hidden" name = "pageNum" value="${pageNum }"/>
		<input type = "hidden" name = "user" value="${loginUser.u_id}"/>
		<table>
		<tr>
		<td class = "td_left">
		<label for = "writer">작성자 : </label>
		</td>
		<td class = "td_right">		
		<input type = "text" name = "writer" id = "writer"
		value = "${article.writeID}"
		required = "required">
		</td>		
		</tr>
		<tr>
		<td class = "td_left">
		<label for = "subject">제목 : </label>
		</td>
		<td class = "td_right">			
		<input type = "text" name = "subject" id = "subject"
		value = "${article.subject }"	>
		</td>		
		</tr>
		<tr>
		<td class = "td_left">
		<label for = "email">Email : </label>
		</td>
		<td class = "td_right">		
		<input type = "email" name = "email" id = "email"
		value = "${article.email }" >
		</td>		
		</tr>
		<tr>
		<td class = "td_left">
		<label for = "content">글내용 : </label>
		</td>
		<td class = "td_right">		
		<textarea id = "content" name = "content" rows = "13" cols = "40">${article.content }</textarea>
	
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
			<input type = "submit" value = "글수정"/>
			<input type = "reset" value = "다시작성"/>
		</td>
		</table>
		</form>
	</section>
</body>
</html>