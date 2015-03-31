<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<%@page import ="java.util.*" %>
	<%@page import ="onlineClass.domain.Roll" %>
	<%@page import ="onlineClass.domain.Course" %>
	<%@page import ="onlineClass.domain.Subject" %>
	<%@page import ="onlineClass.domain.Category" %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>GDUFS 在线课堂</title>
	
	<script src="../resource/js/index.js"></script>
    <link href="../resource/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resource/css/bootstrap-combined.min.css" rel="stylesheet">
	<link href="../resource/css/index.css" rel="stylesheet">
	<script src="../resource/js/jquery.js"></script>
    <script src="../resource/js/bootstrap.min.js"></script>
  </head>

  <body>
  	<% 
		String my_name = request.getAttribute("my_name").toString();
	%>
	<div class = "container-fluid">
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="span1"></div>
		<div class="span9">
		<a class="navbar-brand" href="#">GDUFS 在线课堂</a>    
			<ul class="nav nav-pills">
            <li class="active"><a href="#">首页</a></li>
            <li><a href="#about">课程导航</a></li>
            <li><a href="#contact">课程题库</a></li>
            <li><a href="#">我的课堂</a></li>
			<li><a href="#">当前用户：<sec:authentication property="name"/></a></li>
			<li><a href="#">昵称：<%=my_name%></a></li>
          </ul>
        </div>
		<div class="span2"></div>
      </div>
    </div>
    </div>
 
	<!-- 1. the carousel start-->
 
 			<div class="row-fluid">		  
			  <div class="carousel slide" id="carousel-414907" data-ride="carousel" data-interval="3000" data-pause="hover">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-414907" class="active">&nbsp;</li>
					<li data-slide-to="1" data-target="#carousel-414907">&nbsp;</li>
					<li data-slide-to="2" data-target="#carousel-414907">&nbsp;</li>
				</ol>
				
				<div class="carousel-inner">
				
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
					if(i==1){
			%>
				<div class="item active">
				<img alt="" src="../resource/img/<%=roll_picture%>.jpg">
				<div class="carousel-caption" contenteditable="true">
				<h4 id="index_title1"><%=course_name%></h4>
				<p id="index_content1"><%=course_info%></p>
				</div>
				</div>
			<%}else{%>
				<div class="item">
				<img alt="" src="../resource/img/<%=roll_picture%>.jpg">
				<div class="carousel-caption" contenteditable="true">
				<h4 id="index_title1"><%=course_name%></h4>
				<p id="index_content1"><%=course_info%></p>
				</div>
				</div>
			<%}}%>
			
				</div>
				
				<a class="carousel-control left" data-slide="prev" href="#carousel-414907">‹</a> 
				<a class="carousel-control right" data-slide="next" href="#carousel-414907">›</a>
				</div>
			</div>
	<!-- 1. the carousel end-->
	
	<!-- 2. the content start-->
<div class="row-fluid category">
<div class="span1"></div>


<div class="span10">
	<!-- 2.1 -->
	<div class="row-fluid">	
		<div class="span9">
			<div class="row-fluid">
			<% 
				List<Subject> subjectList = (ArrayList<Subject>)request.getAttribute("subjectList");
				List<List<Category>> cat_listList = (ArrayList<List<Category>>)request.getAttribute("cat_listList");
				for(int i=0;i<subjectList.size();i++){
					Subject subject=subjectList.get(i);
					String subject_name=subject.getSubject_name();
			%>
				<div class="span4">
					<h3  class="text-left">
						<a id="category_<%=i+1%>" href="" target="_blank"><%=subject_name%></a>
					</h3>
					<ul class="inline unstyled">
					<%for(int j=0;j<cat_listList.get(i).size();j++){
						Category category=cat_listList.get(i).get(j);
						String category_name=category.getCategory_name();
					%>
						<li>
							<%=category_name%>
						</li>
					</ul>
					<%}%>
					<p>
						<span class="badge" contenteditable="true">
							<a id="more_<%=i+1%>" href="" target="_blank">more&raquo;</a>
						</span>
					</p>
				<%}%>
				</div>
				
			</div>
		</div>
		<div class="span3">
			<div class="page-header">
				<h3>
					<p>猜你喜欢 <small><span><a id="video_search" class="btn btn-lg btn-success" href="video_search">搜索课程</a></span></small></p>
				</h3>
			</div>
			<div class="row-fluid">
			<% 
				List<Course> randomList = (ArrayList<Course>)request.getAttribute("randomList");
				for(int i=0;i<randomList.size();i++){
					Course course=randomList.get(i);
					String course_name=course.getCourse_name();
					String course_id=course.getCourse_id();
			%>
				<div class="span6">
					<img alt="120x120" id="<%=course_id%>" src="../resource/img/<%=course_id%>.jpg" class="img-circle card"/>
				</div>
			<%}%>
				
			</div>
		</div>
	</div>
</div>
	<div class="span1"></div>
</div>		
	<!-- 2.2 for blank layout---->
	<div class="row-fluid"><hr></div>
		
		<!-- 2.3 ---->
<div class="row-fluid category">
<div class="span1"></div>
<div class="span10 ">
	<div class="row-fluid">
		<br>
			<div id="class_row1" class="row-fluid">
			
			
				<div class="span3 card" >
					<div class="video_card">
						<div class="main_img">
						<a id="video" class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img06.png" alt='' /></a> 
						</div>
						<div class="">
						<p id="video_info_1" class="word">汽车行走的艺术</p>  
						<p id="video_url_1" class="word">吉林大学</p> 
						</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img08.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_1" class="">汽车行走的艺术</p>  
					<p id="video_url_1" >吉林大学</p> 
					</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img05.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_1" class="">汽车行走的艺术</p>  
					<p id="video_url_1" >吉林大学</p> 
					</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img09.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_1" class="">汽车行走的艺术</p>  
					<p id="video_url_1" >吉林大学</p> 
					</div>
					</div>
				</div>

			</div>
			
			<!--for <br/> blank purpose-->
			<div class="row-fluid"><div class="span12"></div></div>
			
			<div id="class_row2" class="row-fluid">
			<div class="span3 card" >
					<div class="video_card">
						<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img06.png" alt='' /></a> 
						</div>
						<div class="">
						<p id="video_info_1" class="word">汽车行走的艺术</p>  
						<p id="video_url_1" class="word">吉林大学</p> 
						</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img08.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_1" class="">汽车行走的艺术</p>  
					<p id="video_url_1" >吉林大学</p> 
					</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img05.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_1" class="">汽车行走的艺术</p>  
					<p id="video_url_1" >吉林大学</p> 
					</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img09.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_1" class="">汽车行走的艺术</p>  
					<p id="video_url_1" >吉林大学</p> 
					</div>
					</div>
				</div>

			</div>
			
			<!--for <br/> blank purpose-->
			<div class="row-fluid"><div class="span12"></div></div>
			
			
			<div id="class_row2" class="row-fluid">
			<div class="span3 card" >
					<div class="video_card">
						<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img06.png" alt='' /></a> 
						</div>
						<div class="">
						<p id="video_info_1" class="word">汽车行走的艺术</p>  
						<p id="video_url_1" class="word">吉林大学</p> 
						</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img08.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_1" class="">汽车行走的艺术</p>  
					<p id="video_url_1" >吉林大学</p> 
					</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_1" class="media-object" width="250px" height="125px" src="./img/img05.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_1" class="">汽车行走的艺术</p>  
					<p id="video_url_1" >吉林大学</p> 
					</div>
					</div>
				</div>
				
				<div class="span3 card" id="">
					<div class="video_card">
					<div class="main_img">
						<a class="pull-left" href="#"><img id="row1_img_12" class="media-object" width="250px" height="125px" src="./img/img09.jpg" alt='' /></a> 
					</div>
					<div class="">
					<p id="video_info_12" class="">汽车行走的艺术</p>  
					<p id="video_url_12" >吉林大学</p> 
					</div>
					</div>
				</div>	
			</div>
			
			<!--for <br/> blank purpose-->
			<div class="row-fluid"><div class="span12"></div></div>
			
	
<div class="span1"></div>
</div>
</div>


	<!-- 2. the content end-->
</div>	
<hr>

<div class="container-fluid footer">
<br><br><br>
footer 
</div>



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
  </body>
</html>
