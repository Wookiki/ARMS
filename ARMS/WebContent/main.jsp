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

    <title>메인화면TEST</title>
   <%UserInfo userInfo = (UserInfo)request.getAttribute("loginUser"); %>

    <link href="MainBootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="MainBootstrap/css/heroic-features.css" rel="stylesheet">
<style>
	#boardSize{
		width: 50px;
		height: 50px;
	}

</style>

</head>

<body>

    <!-- Navigation -->
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
                <a class="navbar-brand" href="#">ARMS</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="userInfoDetailView.jsp">나의정보보기</a>
                    </li>
					<%
					
					if (userInfo!=null && userInfo.isAdminCheck()){
					%>
					<li>
						<a href=""><input type ="button" value = "회원정보수정"></a>
                    		
                    </li>
					<%
					}
					%>
                    <li>
						<a href="logout.arms">로그아웃</a>
                    		
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

    <!-- Page Content -->
    <div class="container">

        <!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1>환영합니다.</h1>
            <p>우리 아파트의 입주민 여러분 환영합니다. 입주민 간의 활발한 소통의 장이 되어봅시다.</p>
        </header>

        <hr>

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>게시판</h3>
            </div>
        </div>
        <!-- /.row -->

        <!-- Page Features -->
        <div class="row text-center">

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    
                    <div class="caption">
                        <h3>공지사항</h3>
                        	
                        	
                        <p>
                            <a href="userListBoard.bo?bName=notice" class="btn btn-primary">게시판이동</a> 
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>아파트일정</h3>

                        <p>
							<a href="userListBoard.bo?bName=calendar" class="btn btn-primary">게시판이동</a> 
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>부대시설</h3>
                        
                        <p>
                            <a href="userListBoard.bo?bName=facility" class="btn btn-primary">게시판이동</a> 
                        </p>
                    </div>
                </div>
            </div>
			
            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>봉사활동</h3>

                        <p>
                             <a href="userListBoard.bo?bName=volunteer" class="btn btn-primary">게시판이동</a> 
                        </p>
                    </div>
                </div>
            </div>
            
            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>건의사항</h3>

                        <p>
                            <a href="userListBoard.bo?bName=suggestion" class="btn btn-primary">게시판이동</a> 
                        </p>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="MainBootstrap/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="MainBootstrap/js/bootstrap.min.js"></script>

</body>

</html>