<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html"src/main/java/onlineClass/encryption/MD5.java">
  <head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content=""><title>GDUFS-在线课堂登录</title>

    <!-- Bootstrap core CSS -->
    <link href="../resource/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resource/css/register.css" rel="stylesheet">
	<link href="../resource/css/signin.css" rel="stylesheet">
	<link href="../resource/css/myadjustcss.css" rel="stylesheet">
	
    <script src="../resource/js/ie-emulation-modes-warning.js"></script>
    <script src="../js/ie10-viewport-bug-workaround.js"></script>
	<script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </head>
  <body>
  <br/><br/>
  
  <div class="navbar-inverse navbar-fixed-top" role="navigation">
  <h3 id="loginnav">GDUFS-在线课堂</h3>
  </div>
    <div class="container">
	
	 <div class="container-fluid whitebody">
	 <div class="row-fluid" id="login">
		<br/>
		<h3><strong>欢迎登录在线课堂</strong></h3>
		<hr>

		<form class="form-signin" action="../j_spring_security_check" method="post">
		
			<input type="email" class="form-control" name="j_username" placeholder="Email address" required autofocus>
			<br/><br/>
			<input type="password" class="form-control" name="j_password" placeholder="Password" required>
			<br/>
			<p id="login-error" class="erro_tips">${error}</p>
			<br/>
			<button class="btn btn-primary" name="login" type="submit">登录</button>
			<button class="btn btn-primary" name="register" type="submit">现在注册</button>
		</form>
		<br/>
	</div>
	</div>
    </div>
  </body>
</html>
