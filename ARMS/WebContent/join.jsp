<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="UTF-8">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>bootstrap template</title>

    <!-- Bootstrap -->
    <link href="joinBootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="joinBootstrap/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="joinBootstrap/style.css" media="screen" title="no title" charset="utf-8">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>


      <article class="container">
        <div class="page-header">
          <h1>입주민가입 </h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form action  = "join.arms" method = "post" role="form">
            <div class="form-group">
              <label for="id">ID</label>
              <input type="text" class="form-control" id="id" placeholder="ID" required>
            </div>
            <div class="form-group">
              <label for="passwd">비밀번호</label>
              <input type="password" class="form-control" id="passwd" placeholder="비밀번호" required>
            </div>
            
            <div class="form-group">
              <label for="name">이름</label>
              <input type="text" class="form-control" id="name" placeholder="이름을 입력해 주세요" required>
            </div>
            
            <div class="form-group">
              <label for="dong">거주 동</label>
              <input type="text" class="form-control" id="dong" placeholder="동" required>
            </div>
            
            <div class="form-group">
              <label for="ho">거주 호</label>
              <input type="number" class="form-control" id="ho" placeholder="숫자만 입력해주세요." required>
            </div>
            
            <div class="form-group">
              <label for="tel">전화번호</label>
              <input type="tel" class="form-control" id="tel" placeholder="예)010-0000-0000 / 02-0000-0000" required>
            </div>
           
           <div class="form-group">
              <label for="car">보유차량수</label>
              <input type="number" class="form-control" id="text" placeholder="숫자만 입력해 주세요." required>
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
