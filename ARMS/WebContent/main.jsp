<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>아파트 메인화면</title>
<style>
 #wr{
  width : 800px;
  margin : auto;
  
 }
 header{
  height : 50px;
  background : orange;
  text-align: center;
  margin: auto;
  font-size:40px;
 }
 #main{
  margin-top: 10px;
 }
 #main_left{
  height : 500px;
  width : 300px;
 border: 2px solid orange;
  margin-right : 10px;
  float : left;
  text-align:center;
  font-size:20px;
  }
 h1{
 	text-align:center;
 }
 #main_right{
  height : 500px;
  width : 480px;
  background: skyblue;
  float : left;
 }
 footer{
  height : 150px;
  margin-top : 10px;
  background: orange;
 }
 #footerleft{
 float : left;

 }
 #footerRight{
 float : right;
 }
 .button {
    color: black;
    padding: 15px 32px;
    text-align: center;
   
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    
}
#nav_bottom{
	
	}
 
</style>

</head>
<body>
	<section id="wr">
  <header>
  	아파트메인화면
  </header>
  <form action="main.arms" method = "post">
  <section id = "main">
   <nav id = "main_left">
   <h1>게시판목록</h1>
    <a href="3.html"><input type="button" class="button" value="공지사항게시판"></a><p>
    <a href="3.html"><input type="button" class="button" value="부대사항게시판"></a><p>
    <a href="3.html"><input type="button" class="button" value="봉사활동게시판"></a><p>
    <a href="3.html"><input type="button" class="button" value="아파트일정"></a><p>
   
   </nav>   
   <section id = "main_right">
     <h1> 나의 정보 </h1>
     ID : <p>
     이름 : <p>
      <nav id="nav_bottom">
      <a href="3.html"><input type="button" class="button" value="상세보기"></a><p>
      </nav>
   </section>
  </section>
  <div style="clear:both"></div>
  
  
  <footer>
  <section id = footerleft>
  <a href="3.html"><input type="button" class="button" value="로그아웃"></a>
  </section>
  <section id = footerRight>
  <a href="3.html"><input type="button" class="button" value="채팅방입장"></a>  </section>
</form>

</body>
</html>