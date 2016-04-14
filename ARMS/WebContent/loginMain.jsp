<%@page import="arms.web.login.vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="bootstrap/favicon.ico">
\
    <title>로그인화면</title>

    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/ie10-viewport-bu\g-workaround.css" rel="stylesheet">
    <link href="bootstrap/signin.css" rel="stylesheet">
    <script src="bootstrap/ie-emulation-modes-warning.js"></script>
    
  </head>

  <body>

    <div class="container">

      <form action="login.arms" method = "post" class="form-signin">
        <h2 class="form-signin-heading">아파트 로그인</h2>
        <label for="id" class="sr-only">ID</label>
        <input type="text" name = "id" id="id" class="form-control" placeholder="ID" >
        <label for="passwd" class="sr-only">Password</label>
        <input type="password" name = "passwd" id="passwd" class="form-control" placeholder="Password" >
        <br>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
             	
      </form>
      <form class="form-signin">      
      	<button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location = 'joinMainTest.jsp'">회원가입</button>

        
       
      </form>
      
     	

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bootstrap/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>