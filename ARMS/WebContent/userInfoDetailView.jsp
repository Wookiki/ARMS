<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex">

<link href="MainBootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="MainBootstrap/css/heroic-features.css" rel="stylesheet">


    <title>User profile in tabs - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <style type="text/css">
        
    
    </style>
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'http://bootsnipp.com');
        });
    </script>
</head>
<body>

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
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
	<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">나의 정보</a></li>
      <li><a href="#profile" data-toggle="tab">비밀번호</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        
            <label>ID</label>
            <input type="text" name = "id" class="input-xlarge" value = "${loginUser.getU_id() }">
            <label>이름</label>
            <input type="text" name = "name" class="input-xlarge" value = "${loginUser.getU_name() }">
            <label>동</label>
            <input type="text" name = "dong" class="input-xlarge" value = "${loginUser.getU_dong() }">
            <label>호</label>
            <input type="text" name = "ho" class="input-xlarge" value = "${loginUser.getU_ho() }">
            <label>보유차량수</label>
			<input type="text" name = "car" class="input-xlarge" value = "${loginUser.getU_car() }">
			<label>전화번호</label>
			<input type="text" name = "tel" class="input-xlarge" value = "${loginUser.getU_tel() }">            
          	<div>
          		<a href="main.jsp"><button type = "button" class="btn btn-primary">메인으로</button></a>
          		
        	    <button type = "submit" class="btn btn-primary">수정하기</button>
        	</div>
       
      </div>
      <div class="tab-pane fade" id="profile">
    	<form id="tab2">
        	<label>새 비밀번호</label>
        	<input type="password" class="input-xlarge">
        	<div>
        	    <button type = "submit" class="btn btn-primary">수정하기</button>
        	</div>
    	</form>
      </div>
  </div>
	<script type="text/javascript">
	
	</script>
</body>
</html>