<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Risk Master</title>
<%@ include file="meta_and_script.jsp"%>
</head>
<body>
<script>
	<s:if test="#session.user==null">
		window.location.href= "/maven-web-demo/login.jsp";
	</s:if>
	<s:elseif test="#session.user.userType==0">
		window.location.href= "/maven-web-demo/mycourse/TeacherMyCourse";
	</s:elseif>
	<s:else>
	window.location.href= "/maven-web-demo/mycourse/StudentMyCourse";
	</s:else>
		
</script>
</body>
</html>	
