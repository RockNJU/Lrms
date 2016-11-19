<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>风险状态跟踪</title>
<%@ include file="meta_and_script.jsp"%>
<script src="/maven-web-demo/js/mysift.js" ></script>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<div class="admission">
		<div class="container">


			<div class="row">

				<h2>风险基本信息</h2>

				<div class="col-md-6 admission_left">
					<form action="" method="post" id="riskDetialForm" onsubmit="return false;">
						<s:if test="isFollow=='true'">

						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">风险编号：</span> 
							<input type="text" readonly name="assignment.assignmentid" style="width:80%;float:right;" value="<s:property value='assignment.assignmentid' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">风险标题：</span> 
							<input type="text" name="assignment.title" style="width:80%;float:right;" value="<s:property value='assignment.title' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">风险内容：</span> 
							<input type="text" name="assignment.content" style="width:80%;float:right;" value="<s:property value='assignment.content' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">可能性：</span> 
							<input type="text" name="assignment.possibility" style="width:80%;float:right;" value="<s:property value='assignment.possibility' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">影响程度：</span> 
							<input type="text" name="assignment.impact" style="width:80%;float:right;" value="<s:property value='assignment.impact' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">触发器：</span> 
							<input type="text" name="assignment.trig" style="width:80%;float:right;" value="<s:property value='assignment.trig' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">提交者：</span> 
							<input type="text" readonly name="assignment.submitUid" style="width:80%;float:right;" value="<s:property value='assignment.submitUid' />" class="form-control has-dark-background" />
						</div>
						
						
						<div style="height:10px;"></div>
						
						<input type="button" id="updateRiskBtn" value="保存" class="course-submit" onclick="checkUpdateRisk()" />
						</s:if>
						<s:else>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">风险编号：</span> 
							<input type="text" readonly name="assignment.assignmentid" style="width:80%;float:right;" value="<s:property value='assignment.assignmentid' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">风险标题：</span> 
							<input type="text" readonly name="assignment.title" style="width:80%;float:right;" value="<s:property value='assignment.title' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">风险内容：</span> 
							<input type="text" readonly name="assignment.content" style="width:80%;float:right;" value="<s:property value='assignment.content' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">可能性：</span> 
							<input type="text" readonly name="assignment.possibility" style="width:80%;float:right;" value="<s:property value='assignment.possibility' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">影响程度：</span> 
							<input type="text" readonly name="assignment.impact" style="width:80%;float:right;" value="<s:property value='assignment.impact' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">触发器：</span> 
							<input type="text" readonly name="assignment.trig" style="width:80%;float:right;" value="<s:property value='assignment.trig' />" class="form-control has-dark-background" />
						</div>
						
						<div class="input-group input-group1" style="text-align:center;">
							<span style="padding-top:5px;float:left;font-size:20px;">提交者：</span> 
							<input type="text" readonly name="assignment.submitUid" style="width:80%;float:right;" value="<s:property value='assignment.submitUid' />" class="form-control has-dark-background" />
						</div>
						
						</s:else>
					</form>

				</div>


			</div>
			
			<br />
			<br />
			
			<div class="row">
				<h2>风险跟踪者</h2>
				
				<s:if test="isFollow=='true'">
				
				<div class="input-group input-group1">
				
				<input class="form-control has-dark-background" style="width:50%;" name="teacher-uid" placeholder="添加跟踪者" type="text" id="addFollowInput"/>
				<input type="button" id="addFollowBtn" style="margin-left:30px;" value="添加" class="course-submit" onclick="addFollow();" />
				</div>
				
				</s:if>
				
			<div class="clearfix"></div>
			<table class="timetable" id="followTable">
				<thead>
					<tr>
						<th>用户编号</th>
						<th>用户名称</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${followList}">
						<tr>
							<td>${item.uid}</td>
							<td>${item.username}</td>
							<s:if test="isFollow=='true'">
							<td><input type="button" name="${item.uid}" value="删除" class="course-submit" onclick="delFollow(this);"></td>
							</s:if>
							<s:else>
							<td>-</td>
							</s:else>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			</div>
			
			<br />
			<br />

			<div class="row">

			<h2>风险状态跟踪</h2>
			
			<s:if test="isFollow=='true'">

			<div class="col-md-6 admission_left">
				<div class="input-group input-group1">
					<select id="stateDesc">
						<option value="risk">风险</option>
						<option value="problem">问题</option>
					</select>
				</div>
				<div class="input-group input-group1">
					<input class="form-control has-dark-background" id="content"
						placeholder="详细信息" type="text" />
				</div>
			</div>

			<div>
				<input class="course-submit" type="submit" value="发布" id="submitBtn" />
			</div>
			
			</s:if>
			
			</div>

			<div class="clearfix"></div>
			<table class="timetable" id="assignmentTable">
				<thead>
					<tr>
						<th>时间</th>
						<th>状态描述</th>
						<th>详细信息</th>
						<th>提交者</th>
						<th>操作</th>						
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${reports}">
						<tr>
							<td>${item.createdAt}</td>
							<td><input name="name_1" type="text" class="no-box"
								value="${item.stateDesc}" readOnly="readOnly"></td>
							<td><input name="name_1" type="text" class="no-box"
								value="${item.content}" readOnly="readOnly" /></td>
							<td><input name="name_1" type="text" class="no-box"
								value="${item.uid}" readOnly="readOnly"></td>
							
							<c:if test="${item.stateDesc=='风险'}">
							
								<td><input name="name_1" type="button" class="course-submit"
								value="演变为问题" ></td>
							
							</c:if>
							<c:if test="${item.stateDesc=='问题'}">
							<td>-</td>
							
							</c:if>
							<c:if test="${item.stateDesc!='风险'&&item.stateDesc!='问题'}">
							<td>-</td>
							
							</c:if>							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="clearfix"></div>
		</div>
	</div>

	<script>
	
	
	
	var teacherinfo = [];
   	var teacherids = [];
   	var dropdowns = [];
   	<c:forEach var="item" items="${userList}">
   		teacherinfo.push("${item.uid}" + "   " + "${item.username}" );
   		teacherids.push("${item.uid}");
   	</c:forEach>
   	dropdowns.push(new mSift('dropdowns[0]', 20));
   	//数据 
   	dropdowns[0].Data = teacherinfo;
   	dropdowns[0].Ids = teacherids;
   	//指定文本框对象建立特效 
   	var dropdownCount = 1;
   	
   	bindFirstText();
   	
   	function bindFirstText() {
   		$("#addFollowInput").bind("keydown", function (e) {
   			var curKey = e.which;
   			if (curKey == 13) {

   			}
   		});
   		dropdowns[0].Create(document.getElementById('addFollowInput'));
   	}
	
	
	
	
		var assignmentid = $
		{
			assignmentid
		};

		var $btn = $("#submitBtn");
		$btn.bind("click", function() {
			var stateDesc = $('#stateDesc option:selected').val();
			var content = $("#content").val();
			$.ajax({
				type : "post",
				url : "/maven-web-demo/assignment/SubmitReport",
				data : {
					stateDesc : stateDesc,
					content : content,
					assignmentid : assignmentid
				},
				dataType : "json",
				success : function(data) {
					if (data == "deny") {
						alert("操作拒绝：您不是该风险的跟踪者。");
					} else if (data == "success") {
						alert("发布成功！");
						window.location.reload(true);
					} else {
						alert("发布失败：请检查输入。");
					}
				},
				error : function() {
					alert("系统异常，请稍后重试！");
				},
			});
		});
		
		function format(date) {
			return date.substring(0, 10);
		}
		
		function checkUpdateRisk(){
			console.log($("#riskDetialForm").serialize());
			
			var d=$("#riskDetialForm").serialize();
			
			$.ajax({
				type : "post",
				url : "/maven-web-demo/assignment/AddAssignment!updateAssignmentInf",
				data : d+"&cid=<s:property value='cid' />",
				dataType : "json",
				success : function(data) {
					if (data == "deny") {
						alert("操作拒绝：您不是该风险的跟踪者。");
					} else if (data == "success") {
						alert("修改成功！");
						window.location.reload(true);
					} else {
						alert("修改失败：请检查输入。");
					}
				},
				error : function() {
					alert("系统异常，请稍后重试！");
				},
			});
			
		}
		
		function delFollow(a){
			var fid=$(a).attr("name");
			var aid="<s:property value='assignment.assignmentid' />";
			
			$.ajax({
				type : "post",
				url : "/maven-web-demo/assignment/AddAssignment!delFollow",
				data : "aid="+aid+"&fid="+fid,
				dataType : "json",
				success : function(data) {
					if (data == "deny") {
						alert("操作拒绝：您不是该风险的跟踪者。");
					} else if (data == "success") {
						alert("删除成功！");
						window.location.reload(true);
					} else if(data=="fail_self"){
						alert("删除失败：不能删除自己。");
					} else if(data=="fail_assignment_null"){
						alert("删除失败：该风险不存在。");
					} else if(data=="fail_creator"){
						alert("删除失败：不能删除风险提交者。");
					} else {
						alert("删除失败：请检查。");
					}
				},
				error : function() {
					alert("系统异常，请稍后重试！");
				},
			});
			
		}
		
		function addFollow(){
			
			if(dropdowns.length<=0){
				return -1;
			}
			
			var fid=dropdowns[0].GetSelectedId();
			var aid="<s:property value='assignment.assignmentid' />";
			
			$.ajax({
				type : "post",
				url : "/maven-web-demo/assignment/AddAssignment!addFollow",
				data : "aid="+aid+"&fid="+fid,
				dataType : "json",
				success : function(data) {
					if (data == "deny") {
						alert("操作拒绝：您不是该风险的跟踪者。");
					} else if (data == "success") {
						alert("添加成功！");
						window.location.reload(true);
					} else {
						alert("删除失败：请检查。");
					}
				},
				error : function() {
					alert("系统异常，请稍后重试！");
				},
			});
			
		}
		
	</script>

	<%@ include file="footer.jsp"%>
</body>
</html>
