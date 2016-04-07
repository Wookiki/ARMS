<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>봉사활동게시판목록화면</title>
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

<body>
	<c:if test="${pageInfo.count != 0}">
	<section id = "listArea">
		<h2>봉사활동 게시판 </h2>
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
		<td class = "td_number">${number}</td>
		<c:set var = "number" value = "${number -1}"></c:set>
		<td class = "td_subject">
		
		<c:if test="${article.re_level > 0 }">
		<c:forEach begin="1" end="${article.re_level }" step = "1">
		&nbsp;&nbsp;&nbsp;
		</c:forEach>
			re :
			</c:if>
		<a href = "boardContent.bo?num=${article.num}&pageNum=${pageInfo.currentPage}">${article.subject}</a>
		</td>
		<td class = "td_writer">${article.writer }</td>
		<td class = "td_regdate">
		<fmt:formatDate var = "reg_date" value = "${article.reg_date}" pattern = "yyyy.MM.dd"/>
		<c:out value="${reg_date}"></c:out>
		</td>
		<td class = "td_readcount">${article.readcount}</td>
		</tr>
		</c:forEach>
		</table>
		
		<section id = pageArea>
		<c:if test="${pageInfo.startPage > 10}">
			<a href = "boardList.bo?pageNum=${pageInfo.startPage - 10}">[이전]</a>
		</c:if>
		<c:forEach var = "i" begin = "${pageInfo.startPage}" end = "${pageInfo.endPage}">
		<a href = "boardList.bo?pageNum=${i}">[${i}]</a>
		</c:forEach>
		<c:if test="${pageInfo.endPage < pageInfo.pageCount}">
			<a href = "boardList.bo?pageNum=${pageInfo.startPage + 10}">[다음]</a>
		</c:if><br>
        <tr>
        	<td colspan = "1" id = "commandCell">
        	<a href="main.jsp"><input type="button" value="메인으로" /></a></td>
		</tr>
		</section>
		
	</section>
	</c:if>
</body>
</html>