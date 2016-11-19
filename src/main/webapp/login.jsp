<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<%@ include  file="meta_and_script.jsp"%>
</head>
<body>
<%@ include  file="navigation.jsp"%>

	<div class="courses_box1">
	   <div class="container">
	   	  <s:form class="login" action="user/Login" method="post">
	    	<p class="lead">欢迎!</p>
		    <div class="form-group">
			    <input autocomplete="off" type="text"  class="required form-control" placeholder="学工号" name="uid" >
		    </div>
		    <div class="form-group">
			    <input autocomplete="off" type="password" class="password required form-control" placeholder="密码" name="password">
		    </div>
		    <s:if test="#request.errorMessage!=null">
	    		<p style="color:red"><s:property value="#request.errorMessage" /></p>	
	    	</s:if>
		    <div class="form-group">
		    	<input type="submit" class="btn btn-primary btn-lg1 btn-block" name="submit" value="登录">
		    </div>
		 </s:form>
	   </div>
	</div>
<%@ include  file="footer.jsp"%>
</body>
</html>	
