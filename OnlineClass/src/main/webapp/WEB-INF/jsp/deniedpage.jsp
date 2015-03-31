<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../resource/css/layout.css">
<title>Error</title>
<script type="text/javascript">     
function countDown(secs,surl){     
 //alert(surl);     
    var jumpTo = document.getElementById('jumpTo');
    jumpTo.innerHTML=secs;  
    if(--secs>0){     
        setTimeout("countDown("+secs+",'"+surl+"')",1000);     
     }     
    else{       
        location.href=surl;     
        }     
}     
</script> 
</head>

<body>
	<div class="container main">
		<div class="success_text" id="change_success">
			<p id="erro_icon">
				You have no authority to access this page!
				<br/>
				<br/>
				<center><p id="jumpTo"></p></center>
			</p>
		</div>
	</div>
</body>
<script type="text/javascript">
	countDown(5,'/TRM/auth/login');
</script> 
</html>