<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
     <!--  <link rel="icon" href="../../assets/ico/favicon.ico">-->

    <title>GDUFS-在线课堂注册</title>

    <!-- Bootstrap core CSS -->
    <link href="../resource/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resource/css/register.css" rel="stylesheet">
	<link href="../resource/css/signin.css" rel="stylesheet">
	<link href="../resource/css/myadjustcss.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../resource/js/ie-emulation-modes-warning.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../resource/js/ie10-viewport-bug-workaround.js"></script>
<script src="../resource/js/jquery.min.js"></script>
    <script src="../resource/js/bootstrap.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.1/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<script>	
jQuery(document).ready(function($) {
$('.theme-login').click(function(){
$('.theme-popover-mask').fadeIn(100);
$('.theme-popover').slideDown(200);
})
$('.theme-poptit .close').click(function(){
$('.theme-popover-mask').fadeOut(100);
$('.theme-popover').slideUp(200);
})
})
</script>
  <body>
  <br/><br/>
  
  <div class="navbar-inverse navbar-fixed-top" role="navigation">
  <h3 id="loginnav">GDUFS-在线课堂</h3>
  </div>
  
  <div class="container">
	
	 <div class="container-fluid whitebody">
	 <div class="row-fluid" id="login">
		<br/>
		<h3><strong>欢迎注册在线课堂</strong></h3>
		<hr>

		<form class="form-signin" action="/OnlineClass/user/register" method="post">
		
			<input type="email" class="form-control" name="user_id" placeholder="Email address" required autofocus>
			<br/>
			<input type="password" class="form-control" name="password" placeholder="Password" required>
			<br/>
			<input type="text" class="form-control"  name="user_name" placeholder="Username" required>
			<br/>
			<button class="btn btn-primary btn-md theme-login" name="register" type="submit">现在注册</button>
		</form>
		<br/>
	</div>
	</div>
    </div> 
  </body>
</html>