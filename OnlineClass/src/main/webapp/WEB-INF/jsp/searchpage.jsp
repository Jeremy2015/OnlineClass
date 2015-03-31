<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resource/js/jquery.js"></script>
</head>
<body>
<input type="text" id="keyword"/><button type="button" onclick="postkeyword()">搜索</button></br>
<p></p>
</body>
<script type="text/javascript">
function postkeyword(){
	$.ajax({
		url:"/OnlineClass/video/search",
		data:"keyword="+eval(document.getElementById('keyword')).value,
		type:"get",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		dataType:"json",
		success:function(result){
			$.each(result, function(key, val) { 
		    	$('p').append(key+" "+val+"</br>");
		      });
		},
		error:function(){
			alert("搜索结果为空，请重新搜索！");
		}
	});
}

</script>
</html>