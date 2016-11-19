<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>我的项目</title>
<%@ include file="meta_and_script.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/maven-web-demo/css/flexslider.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<div class="courses_box1">
		<div class="container">

			<%@include file="sidebar.jsp"%>
			<div class="col-md-9">
				<div class="course_list">
					<div class="table-header clearfix">
						<div class="name_col">项目名称</div>
						<div class="duration_col">风险等级</div>
						<div class="date_col">状态</div>
					</div>
					<ul class="table-list">
						<c:forEach var="item" items="${myTeachCourse}">
							<li class="clearfix">
								<div class="name_col">
									<a class="courseLink">${item.coursename}</a>
								</div>
								<div class="duration_col">${item.credit}</div> 
								<c:if test="${item.state eq 2 }">
									<div class="date_col" style="color:red">已结束</div>
								</c:if> 
								<c:if test="${item.state eq 1 }">
									<div class="date_col" style="color:blue">进行中</div>
								</c:if>
								 <c:if test="${item.state eq 0 }">
									<div class="date_col" style="color:green">未开始</div>
								</c:if>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	<script>
			
			$(document).ready(function() {
				var as = document.getElementsByClassName("courseLink");
				var i = 0;
				<c:forEach var="item" items="${myTeachCourse}">
					as[i].setAttribute("href", "/maven-web-demo/coursedetail/CourseDetailPage.action?cid=" + "${item.cid}");
					i++;
				</c:forEach>
			});
		
		</script>


</body>
</html>
