<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import ="java.util.*" %>
<%@page import ="onlineClass.domain.Roll" %>
<%@page import ="onlineClass.domain.Course" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>Failed</h1>
<p>test roll</p>
<% 
	List<Roll> rollList = (ArrayList<Roll>)request.getAttribute("rollList");
	List<Course> rollCourseList = (ArrayList<Course>)request.getAttribute("rollCourseList");
	for(int i=0;i<rollList.size();i++){
		Roll roll=rollList.get(i);
		Course course=rollCourseList.get(i);
		String course_id=roll.getCourse_id();
		String roll_picture=roll.getRoll_picture();
		String course_name=course.getCourse_name();
		String course_info=course.getCourse_info();
		String university_name=course.getUniversity_name();
%>
		<p class="course"><%=course_id%></p>
		<p class="course"><%=roll_picture%></p>
		<p class="course"><%=course_name%></p>
		<p class="course"><%=university_name%></p>
		<p class="course"><%=course_info%></p><br/>
<%}%>

</body>
</html>