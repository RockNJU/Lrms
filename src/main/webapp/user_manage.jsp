<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="s" uri="/struts-tags" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户管理</title>
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
							<li role="presentation" class="active"><a href="#register"
								id="register-tab" role="tab" data-toggle="tab"
								aria-controls="register" aria-expanded="true">用户注册</a></li>
							<li role="presentation"><a href="#batch" role="tab"
								id="batch-tab" data-toggle="tab" aria-controls="batch">批量注册</a>
							</li>
							<li role="presentation"><a href="#authority" role="tab"
								id="authority-tab" data-toggle="tab" aria-controls="authority">权限管理</a>
							</li>
						</ul>

						<div id="myTabContent" class="tab-content">
							<!-- 第一个选项卡 -->
							<div role="tabpanel" class="tab-pane fade in active" id="register" aria-labelledby="register">
								<form id="register-form">
									<div class="input-group input-group1">
											<input type="text" style="display:none;" />	<!-- 防止回车自动提交 -->
									</div>
									<div class="input-group input-group1" >
										<input class="form-control has-dark-background"
											 name="register-uid" placeholder="工号"
											type="text" />
									</div>
								</form>
								<input type="submit" id="registerbtn" value="注册" class="course-submit-wide">
								<p class="flag"></p>
							</div>

							<!-- 第二个选项卡内容 -->
							<div role="tabpanel" class="tab-pane fade" id="batch" aria-labelledby="batch-tab">
								<form id="batch-form">
									<div class="input-group input-group1">
										<input class="form-control has-dark-background"
											name="startuid" placeholder="起始工号" type="text" />
									</div>
									<div class="input-group input-group1">
										<input class="form-control has-dark-background"
											name="enduid" placeholder="终止工号" type="text" />
									</div>
									<input type="submit" id="batchbtn" value="注册" class="course-submit-wide">
								</form>
								<p class="flag"></p>
							</div>
							
							<!-- 第三个选项卡内容 -->
							<div role="tabpanel" class="tab-pane fade" id="authority" aria-labelledby="authority-tab">
									<!-- 搜索框 -->
								<form>
									<div class="input-group input-group1">
										<input class="form-control has-dark-background"
											id="teacherSearchKey" name="key" placeholder="关键字" type="text" />
									</div>
									<input type="button" id="teacherSearchBtn" value="搜索" class="course-submit-wide">
									<input type="button" id="showAllBtn" value="显示全部" class="course-submit-wide">
								</form>
								
								<table class="timetable" id="teacherTable">
									<thead>
										<tr>
											<th>工号</th>
											<th>姓名</th>
											<th>电子邮箱</th>
											<th>联系电话</th>
											<!-- <th>教学负责人权限</th> -->
											<th>管理员权限</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="tbd">
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
								<script>
								function removeTexts() {
									document.getElementById("register").removeChild(document.getElementById("register-form"));
									var form = document.createElement("form");
									form.setAttribute("id", "register-form");
									var div1 = document.createElement("div");
									div1.setAttribute("class", "input-group input-group1");
									var text1 = document.createElement("input");
									text1.setAttribute("style", "display:none;");
									text1.setAttribute("type", "text");
									div1.appendChild(text1);
									form.appendChild(div1);
									
									var div2 = document.createElement("div");
									div2.setAttribute("class", "input-group input-group1");
									var text2 = document.createElement("input");
									text2.setAttribute("name", "register-uid");
									text2.setAttribute("class", "form-control has-dark-background");
									text2.setAttribute("placeholder", "工号");
									text2.setAttribute("type", "text");
									div2.appendChild(text2);
									form.appendChild(div2);
									
									document.getElementById("register").insertBefore(form, document.getElementById("registerbtn"));
									bindFirstText()
								}
							
								function addNewText() {
									var div = document.createElement("div");
									div.setAttribute("class", "input-group input-group1");
									var text = document.createElement("input");
									text.setAttribute("class", "form-control has-dark-background");
									text.setAttribute("placeholder", "工号");
									text.setAttribute("type", "text");
									text.setAttribute("name", "register-uid");
									$(text).bind("keydown", function (e) {
										var curKey = e.which;
										if (curKey == 13) {
											addNewText();
											document.getElementById("register-form").lastChild.lastChild.focus();
										}
									});
									div.appendChild(text);
									$("#register-form").append(div);
								}
								
								function registerBtn() {
									var $btn = $("#registerbtn");
									$btn
											.bind(
													"click",
													function() {
														var list = [];
														var texts = document.getElementsByName("register-uid");
														for (var i=0;i<texts.length;i++) {
															list.push(texts[i].value);
														}
														$.ajax({
																	type : "post",
																	url : "user/UserRegister",
																	data : {
																		uidlist:JSON.stringify(list)
																	},
																	dataType : "json",
																	success : function(data) {
																		removeTexts();
																		$(".flag")[0].innerHTML = data;
																	},
																	error : function() {
																		alert("系统异常，请稍后重试！")
																	}
																});
													})
								}
								
								function bindFirstText() {
									$("input[name='register-uid']").bind("keydown", function (e) {
										var curKey = e.which;
										if (curKey == 13) {
											addNewText();
											document.getElementById("register-form").lastChild.lastChild.focus();
										}
									});
								}
								
								function batchBtn() {
									var $btn = $("#batchbtn");
									$btn
											.bind(
													"click",
													function() {
														$.ajax({
																	type : "post",
																	url : "user/UserBatchRegister",
																	timeout : 10000,
																	data : {
																		startuid:$("input[name=startuid]").val(),
																		enduid: $("input[name=enduid]").val()
																	},
																	dataType : "json",
																	success : function(data) {
																		$(".flag")[1].innerHTML = data;
																	},
																});
														alert("注册成功!");
													})
								}
								
								function changeAuthority(a) {
									var uid = a.id.substring(1);
									var did = "d" + uid;
									var aid = "a" + uid;
									//var isDirector = document.getElementById(did).checked; 
									var isAdmin = document.getElementById(aid).checked;
									
									$.ajax({
										type : "post",
										url : "user/UserChangeAuthority",
										data : {
											uid: uid,
											isDirector: false,
											isAdmin: isAdmin
										},
										dataType : "json",
										success : function(data) {
											if (data == "success") {
												alert("修改成功");
											}else {
												alert("修改失败：系统异常。")
											}
										},
										error : function() {
											alert("系统异常，请稍后重试！")
										}
									});
								}
								
								function authorityBtn() {
									var $btn = $("#authority-tab");
									$btn.bind("click", refreshTeacherTable());
								}
								
								function teacherSearch() {
									var key = document.getElementById("teacherSearchKey").value;
									$.ajax({
										type : "post",
										url : "user/UserSearchTeacher",
										data : {
											key:key
										},
										dataType : "json",
										success : function(data) {
											fillTeacherTable(data);
										},
										error : function() {
											alert("系统异常，请稍后重试！")
										}
									});
								}
								
								function fillTeacherTable(data) {
									var table = document.getElementById("teacherTable");
								    var rowNum=table.rows.length;
								    <!--表头也算一行,所以从1开始 -->
								     for (i=1;i<rowNum;i++){		
								    	 table.deleteRow(i);
								         rowNum=rowNum-1;
								         i=i-1;
								     }
										var teachers = data[0];
										var users = data[1];
										var count = teachers.length;
										for (var i=0;i<count;i++) {
											var teacher = teachers[i];
											var user = users[i];
											var row = table.insertRow();
											row.insertCell(0).appendChild(document.createTextNode(user.uid));
											row.insertCell(1).appendChild(document.createTextNode(user.username));
											row.insertCell(2).appendChild(document.createTextNode(user.email));
											row.insertCell(3).appendChild(document.createTextNode(user.tel));
											
											/*
											var directBox = document.createElement("input");
											directBox.setAttribute("type", "checkbox");
											directBox.setAttribute("id", "d" + user.uid);
											if (teacher.isDirector) {
												directBox.checked=true;
											}else {
												directBox.checked=false;
											}
											directBox.setAttribute("onclick", "changeAuthority(this)");
											row.insertCell(4).appendChild(directBox);
											*/
											
											var adminBox = document.createElement("input");
											adminBox.setAttribute("type", "checkbox");
											adminBox.setAttribute("id", "a" + user.uid);
											if (teacher.isAdmin) {
												adminBox.checked=true;
											}else {
												adminBox.checked=false;
											}
											adminBox.setAttribute("onclick", "changeAuthority(this)");
											row.insertCell(4).appendChild(adminBox);
											
											var delBtn = document.createElement("input");
											delBtn.setAttribute("type", "button");
											delBtn.setAttribute("id", user.uid);
											delBtn.setAttribute("value", "删除");
											delBtn.setAttribute("class", "course-submit");
											delBtn.setAttribute("onclick", "delUser(this)");
											row.insertCell(5).appendChild(delBtn);
										}
								}
								
								function refreshTeacherTable() {
								     $.ajax({
											type : "get",
											url : "user/UserShowAllTeacher",
											data : {
											},
											dataType : "json",
											success : function(data) {
												fillTeacherTable(data);
											},
											error : function() {
												alert("系统异常，请稍后重试！")
											}
										});
								}
								
								function delUser(btn) {
									var uid = btn.id;
									$.ajax({
										type : "post",
										url : "user/UserDel",
										data : {
											uid: uid,
										},
										dataType : "json",
										success : function(data) {
											if (data == "success") {
												alert("删除成功");
												refreshTeacherTable();
											}else {
												alert("删除失败：系统异常。")
											}
										},
										error : function() {
											alert("系统异常，请稍后重试！")
										}
									});
								}
								
								

								$(document).ready(function() {
									registerBtn();
									bindFirstText();
									batchBtn();
									authorityBtn();
									document.getElementById("teacherSearchBtn").setAttribute("onclick","teacherSearch()");
									document.getElementById("showAllBtn").setAttribute("onclick","refreshTeacherTable()");
								});

							</script>
	
	
	<%@ include file="footer.jsp"%>
</body>
</html>
