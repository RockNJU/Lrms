<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="s" uri="/struts-tags" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>个人信息</title>
<%@ include file="meta_and_script.jsp"%>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<div class="courses_box1">
		<div class="container">
			<div class="col-md-12 grid_1_right">
				<div class="but_list">
					<div class="bs-example bs-example-tabs" role="tabpanel"
						data-example-id="togglable-tabs">

						<!-- 选项卡栏目 -->
						<ul id="myTab" class="nav nav-tabs nav-tabs1" role="tablist">
							<li role="presentation" class="active"><a href="#profile"
								id="profile-tab" role="tab" data-toggle="tab"
								aria-controls="profile" aria-expanded="true">基本资料</a></li>
							<li role="presentation"><a href="#changepw" role="tab"
								id="changepw-tab" data-toggle="tab" aria-controls="changepw">修改密码</a>
							</li>
						</ul>


						<div id="myTabContent" class="tab-content">

							<!-- 第一个选项卡 -->
							<div role="tabpanel" class="tab-pane fade in active" id="profile"
								aria-labelledby="profile-tab">
								<div class="copy">
								<p>工号：<s:property value="#session.user.uid" /></p>
								<p>姓名：<s:property value="#session.user.username" /></p>
								<s:if test="#session.user.gender==0">
									<p>性别：男</p>
								</s:if>
								<s:else>
									<p>性别：女</p>
								</s:else>
								<p>出生日期：<fmt:formatDate value="${ session.user.birthday}" pattern="yyyy年MM月dd日" /></p>
								</div>
								<!-- 修改邮箱、电话、头像 -->							
								<s:form class="login" action="/user/UserProfile" method ="post">
									<div class="form-group">
										<input type="text" placeholder="邮箱" autocomplete="off" class="required form-control"  name="email" value="${session.user.email}" />
									</div>
									<div class="form-group">
										<input type="text" placeholder="联系电话" autocomplete="off" class="required form-control"  name="tel" value="${session.user.tel}">
									</div>
									<div class="form-group">
										<input type="submit" class="btn btn-primary btn-lg1 btn-block"  name="submit" value="提交">
									</div>
								</s:form>
								<p id="prompt"></p>
							</div>

							<script> 
							
								function btn() {
									var $btn =$("#changepwbtn");
									$btn.bind("click", function(){
										var p1 = document.getElementById("p1").value;
										var p2 = document.getElementById("p2").value;
										if (p1!=p2) {
											alert("两次密码不一致，请重新输入！");
											return ;
										}
										$.ajax({
											type:"post",
											url:"user/UserChangePassword",
											data:{
												oldpw: $("input[name=oldpw]").val(),
												newpw:$("input[name=newpw]").val()
											},
											dataType:"json",
											success:function(data) {
												if (data=="success") {
													alert("修改成功！");
												}else{
													alert("修改失败：原密码错误。");
												}
											},
											error:function(){
												alert("系统异常，请稍后重试！")
											}
										});
									})
								}
								
								$(document).ready(function(){
									btn();
								});
							
							</script>

							<!-- 第二个选项卡内容 -->
							<div role="tabpanel" class="tab-pane fade" id="changepw" aria-labelledby="changepw-tab">
								<!-- 修改密码的表单 -->
								<s:form class="login" onsubmit="checkpw()"  method="post" >
									<div class="form-group">
										<input type="password" class="required form-control"
											placeholder="原密码" name="oldpw" value="">
									</div>
									<div class="form-group">
										<input type="password" class="required form-control"
											placeholder="新密码" name="newpw" value="" id="p1">
									</div>
									<div class="form-group">
										<input type="password" class="required form-control"
											placeholder="确认密码" name="confirmpw" value="" id="p2">
									</div>
									<div class="form-group">
										<input type="button" class="btn btn-primary btn-lg1 btn-block"  id="changepwbtn"  value="提交">
									</div>
								</s:form>
								<p class="flag"></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
