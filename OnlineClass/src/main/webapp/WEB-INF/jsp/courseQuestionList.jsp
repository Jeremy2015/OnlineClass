<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@page import ="java.util.*" %>
<%@page import ="onlineClass.domain.Question" %>
<title>课程测试目录</title>
</head>
<body>
<h1>中文测试</h1>
    <%
    	List<Question> questionList = (ArrayList<Question>)request.getAttribute("questionList");
    	for(int i=0;i<questionList.size();i++){
    		Question question=questionList.get(i);
    		out.print("question "+i+": "+question.getQuestion_name()+"</br>");
    		out.print("A: "+question.getOption_a()+"</br>");
    		out.print("B: "+question.getOption_b()+"</br>");
    		out.print("C: "+question.getOption_c()+"</br>");
    		out.print("D: "+question.getOption_d()+"</br></br></br>");
    	}
    %>
</body>
</html>

