<%@page import="arms.web.board.vo.PageInfo"%>
<%@page import="arms.web.board.dao.BoardDAO"%>
<%@page import="arms.web.board.vo.Article"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항목록화면</title>
<style>
#listArea{
	width: 610px;
	height: 600px;
	margin: auto;
	border: 1px solid red;
	text-align: left;

}
	#pageArea{
		width: 610px;
		height: 600px;
		margin: auto;
		text-align: center;
	}
h2 {
	text-align: center;
	border-bottom: 3px double brown;
}

table {
	width: 580px;
	margin: auto;
	text-align: center;
}
#tr_title{
	background: orange;
}

.td_number,.td_writer,.td.readcount,.td_regdate {
	width: 100px;
}

.td_subject {
	text-align: left;
	width: 200px;
}

#commandCell {
	text-align: center;
}
</style>
</head>
<%!
	//한 페이지당 출력될 글의 갯수
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<body>
	<c:if test="${pageInfo.count != 0 }">
	<section id = "listArea">
		<h2>공지사항 게시판</h2>
		<a href = "writeForm.jsp"> 글쓰기</a>
		<table>
			<tr id = "tr_title">
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
			</tr>
			<c:set var = "number" value = "${pageInfo.number}"></c:set>
			<c:forEach var = "article" items = "${articleList}">
			<tr>
			<td class = "td_number">${number }</td>
			<c:set var = "number" value = "${number-1}"></c:set>
			<td class = "td_subject">
			<c:if test = "${article.re_level > 0 }">			
			<c:forEach begin="1" end = "${article.re_level}" step = "1">
			&nbsp;&nbsp;&nbsp;								
			</c:forEach>
			re :
			</c:if>
		<a href = "boardContent.bo?num=${article.num }&pageNum=${pageInfo.currentPage}">${article.subject }</a>
			</td>
			<td class = "td_writer">${article.writeID }</td>
			<td class = "td_regdate">
			<fmt:formatDate var = "writeDate" value="${article.writeDate }" pattern = "yyyy.MM.dd"/>		
			<c:out value = "${writeDate }"></c:out>
			</td>	
			<td class = "td_readcount">${article.readcount }</td>
			</tr>	
				
			</c:forEach>
		</table>
		
		<section id = "pageArea">
		<c:if test="${pageInfo.startPage > 10}">			
				<a href = "noticeBoardList.bo?pageNum=${pageInfo.startPage - 10 }">[이전]</a>
		</c:if>
			
			<c:forEach var = "i" begin = "${pageInfo.startPage }" end = "${pageInfo.endPage}" >
				<a href = "noticeBoardList.bo?pageNum=${i }">[${i }]</a>
			</c:forEach>
			<c:if test="${pageInfo.endPage < pageInfo.pageCount }">			
				<a href = "noticeBoardList.bo?pageNum=${pageInfo.startPage + 10 }">[다음]</a>
			</c:if><br>
			<tr>
        	<td colspan = "1" id = "commandCell">
        	<input type="reset" value="메인으로" onclick = "location = 'main.jsp'"/></td>
		</tr>
			
		</section>
	</section>
	</c:if>
	 

</body>
</html>