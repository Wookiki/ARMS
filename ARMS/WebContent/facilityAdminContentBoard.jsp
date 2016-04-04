<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부대시설 게시판 내용 보기화면</title>
<style>
#contentArea{
	width: 610px;
	height: auto;
	margin: auto;
	border: 1px solid orange;
	text-align: center;
}
#basicInfo{
	height : 60px;
	border-bottom:1px solid red;
	text-align: center;
}
#contentInfo{
	height : 400px;
	text-align : left;
	overflow: auto;
	border-bottom :1px solid red;
	margin-bottom : 20px;
}
#commandArea{
	height : 10px;
	margin-bottom : 40px;
}
</style>
</head>
<body>
	<section id = "contentArea">
	<h2>부대시설 게시판</h2>
	<section id = "basicInfo">
	제목 : ${conArticle.subject}
	작성자 : ${conArticle.writer}
	조회수 : ${conArticle.readcount}
	작성일 : ${conArticle.reg_date}
	</section>
	<section id = "contentInfo">
	${conArticle.content }
	</section>
	<section id = "commandArea">
	<input type = "button" value = "글 수정" onClick="location.href='boardUpdateForm.bo?num=${conArticle.num }&pageNum=${pageNum }'">
	<input type = "button" value = "글 삭제" onClick="location.href='boardDeleteForm.bo?num=${conArticle.num }&pageNum=${pageNum }'">
	<input type = "button" value = "목록보기" onclick="location.href='boardList.bo'">
	</section>
	</section>
</body>
</html>