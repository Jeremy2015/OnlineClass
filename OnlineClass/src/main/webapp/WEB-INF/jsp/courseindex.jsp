<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resource/js/jquery.js"></script>
</head>
<body>
<h1>课程目录导航</h1>
<button id="all">All Video</button><br/>
<p></p>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#all").click(function(){
		$.ajax({
			url:"/OnlineClass/course/pageList",
			data:"currentPage=2",
			type:"get",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			dataType:"json",
			success:function(result){
				$.each(result, function(key, val) {
					if(key=='pages'){
				    	$('p').append("总页数："+val+"</br>");
					}
					else{
						$.each(val, function(key, val) {
					    	$('p').append("第"+key+"条记录</br>");
					    	$('p').append('course_id: '+val['course_id']+"</br>");
					    	$('p').append('course_name: '+val['course_name']+"</br>");
					    	$('p').append('category_id: '+val['category_id']+"</br>");
					    	$('p').append("</br>");
						});
					}
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