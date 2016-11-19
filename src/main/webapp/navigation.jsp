<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<nav class="navbar navbar-default" role="navigation">
	<div class="container">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
	         <a class="navbar-brand" href="javascript:void(0)">Risk Master</a>
	    </div>
	    <!--/.navbar-header-->
	    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" style="height: 1px;">
	        <ul class="nav navbar-nav">
	        	<s:if test="#session.user==null">
	        		<li class="dropdown">
		            	<s:a href="/maven-web-demo/login.jsp"><i class="fa fa-user"></i><span>登录</span></s:a>
		        	</li>
	        	</s:if>
	        	<s:else>
	        		<li class="dropdown">
		            <s:a href="/maven-web-demo/user/UserPersonal"><i class="fa fa-user"></i><span><s:property value="#session.user.username" /></span></s:a>
		        </li>
	        	</s:else>	        	
		        
		        <li class="dropdown">
		        	<s:if test="#session.user.userType==0" >
		        		<s:a href="/maven-web-demo/mycourse/TeacherMyCourse"><i class="fa fa-list"></i><span>我的项目</span></s:a>
		        	</s:if>
		        	<s:elseif test="#session.user.userType==1">
		        		<s:a href="/maven-web-demo/mycourse/StudentMyCourse"><i class="fa fa-list"></i><span>我的项目</span></s:a>
		        	</s:elseif>
		        </li>
		        
		        
	        	<s:if test="#session.user!=null">
	        		<li class="dropdown">
		            	<s:a href="/maven-web-demo/assignment/AssignmentsIndependentPage"><i class="fa fa-tasks"></i><span>风险管理</span></s:a>
		        	</li>
	        	</s:if>


	        		<li class="dropdown">
	        			<s:if test="#session.user.userType==0" >
		            		<s:a href="/maven-web-demo/statistics.jsp"><i class="fa fa-bar-chart-o"></i><span>统计数据</span></s:a>
		            	</s:if>
		        	</li>


	        	
	        	<s:if test="#session.teacher.isAdmin==true">
	        		<li class="dropdown">
		            	<s:a href="/maven-web-demo/user_manage.jsp"><i class="fa fa-group"></i><span>用户管理</span></s:a>
		        	</li>
	        	</s:if>
	        	
	        	
	        	<!-- 
	        	<s:if test="#session.teacher.isAdmin==true">
	        		<li class="dropdown">
		            	<s:a href="/maven-web-demo/semester_manage.jsp"><i class="fa fa-tasks"></i><span>学期管理</span></s:a>
		        	</li>
	        	</s:if>
	        	 -->
	        	 
	        	 
	        	
	        	<s:if test="#session.teacher.isAdmin==true">
	        		<li class="dropdown">
		            	<s:a href="/maven-web-demo/course/CoursePage"><i class="fa fa-book"></i><span>项目管理</span></s:a>
		        	</li>
	        	</s:if>
	        	
	        	<!-- 
	        	<s:if test="#session.teacher.isAdmin==true">
	        		<li class="dropdown">
		            	<s:a href="/maven-web-demo/schedule/SchedulePage"><i class="fa fa-calendar"></i><span>教学计划</span></s:a>
		        	</li>
	        	</s:if>
	        	*/
	        	 -->
		        
		        <s:if test="#session.user!=null">
	        		<li class="dropdown">
		            	<s:a href="/maven-web-demo/user/Logout"><i class="fa fa-sign-out"></i><span>注销</span></s:a>
		        	</li>
	        	</s:if>
	        	
		     </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
</nav>

