<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="UTF-8">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원가입</title>
   
    <link href="joinBootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="joinBootstrap/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="joinBootstrap/style.css" media="screen" title="no title" charset="utf-8">

	<script>
	function winOpen(){
		//자바스크립트는 화면을 제어할 수 있는 수많은 내장 객체들을 제공하고, 각 내장객체들은
		//속성과 메소드가 제공된다.
		alert(document.forms[0].id.value);
		window.open("idCheck.arms?id=" + document.forms[0].id.value,"window1","width=300,height=300");
	}
</script>
   
  </head>
  <body>


      <article class="container">
        
        <div class="page-header">
          <h1>입주민가입 </h1>
        </div>
        
        <div class="col-md-6 col-md-offset-3">
          
          <form action="join.arms" method="POST" role="form" enctype="multipart/form-data">
            
            <div class="form-group">
              <label for="id">ID</label>
              <input type="text" class="form-control" name = "id" id="id" placeholder="ID" required>
            </div>  
              <div class="form-group">
              <input type = "button" class="btn btn-info" value = "아이디중복체크" onClick = "winOpen()" />
            </div>
            
            <div class="form-group">
              <label for="passwd">비밀번호</label>
              <input type="password" class="form-control" name = "passwd" id="passwd" placeholder="비밀번호" required>
            </div>
            
            <div class="form-group">
              <label for="name">이름</label>
              <input type="text" class="form-control" name = "name" id="name" placeholder="이름을 입력해 주세요" required>
            </div>
            
            <div class="form-group">
              <label for="dong">거주 동</label>
              <input type="text" class="form-control" name = "dong" id="dong" placeholder="동" required>
            </div>
            
            <div class="form-group">
              <label for="ho">거주 호</label>
              <input type="number" class="form-control" min = "1"  name = "ho" id="ho" placeholder="호" required>
            </div>
            
            <div class="form-group">
              <label for="tel">전화번호</label>
              <input type="tel" class="form-control" name = "tel" id="tel" placeholder="예)010-0000-0000 / 02-0000-0000" required>
            </div>
           
           <div class="form-group">
              <label for="car">보유차량수</label>
              <input type="number" class="form-control" min = "1" name = "car" id="car" placeholder="숫자만 입력해 주세요." required>
            </div>
           
            
            <div class="form-group text-center">
              <button type="submit" class="btn btn-info">회원가입<i class="fa fa-check spaceLeft"></i></button>
              <a href = "loginMain.jsp">
              <button type="button" class="btn btn-warning">가입취소<i class="fa fa-times spaceLeft"></i>
              </button>
              </a>
            </div>
          
          </form>
        
        </div>

        
      </article>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="joinBootstrap/bootstrap.min.js"></script>
  </body>
</html>
