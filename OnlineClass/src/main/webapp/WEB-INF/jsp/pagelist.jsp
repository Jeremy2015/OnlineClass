<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<title></title>
</head>
<body>
<h1>Page List</h1>
<button id="all">All Video</button>
<button id="java">Java Video</button>
<button id="html">Html Video</button>
<br/>
<p></p>

</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#all").click(function(){
		$.ajax({
			url:"/OnlineClass/video/all",
			data:"currentPage=2",
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
	});
})
</script>
</html>