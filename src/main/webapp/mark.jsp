<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>风险批改</title>
<%@ include  file="meta_and_script.jsp"%>
</head>
<body>
<%@ include  file="navigation.jsp"%>
	<div class="admission">
	   <div class="container">
	   	  <h2>风险批改</h2>
	   	  
	   	  	<form class="contact_form">
				<div class="col-md-12">
					<textarea placeholder="风险报告总结" id="reportcontent">${reportContent}</textarea>
				</div>
			</form>
			
			<div id="addBtnDiv">
						<input class="course-submit" type="submit" value="提交" id="addBtn" onclick="return false" />
			</div>

	   	  <div class="clearfix"> </div>
			<table class="timetable" id="assignmentTable">
				<thead>
					<tr>
						<th>学号</th>
						<th>得分</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${marks}">
					<tr>
						<td>${item.uid}</td>
						<c:if test="${item.mark<-0.5 }">
							<td><input name="name_1" type="text" class="no-box" value="" /></td>
						</c:if>
						<c:if test="${item.mark>-0.5 }">
							<td><input name="name_1" type="text" class="no-box" value="${item.mark}" /></td>
						</c:if>
						<c:if test="${empty item.comment}">
							<td><input name="name_1" type="text" class="no-box" value=""></td>
						</c:if>
						<c:if test="${not empty item.comment}">
							<td><input name="name_1" type="text" class="no-box" value="${item.comment}"></td>
						</c:if>
					</tr>
					</c:forEach>

					
				</tbody>
			</table>
			<div class="clearfix"> </div>
	   </div>
	</div>
	
	<script>
		addBtn();

		function addBtn() {
			var $btn = $("#addBtn");
			$btn.bind("click", function() {
				var list = [];
				var rows = document.getElementsByTagName("tr");
				
				for (var i=1;i<rows.length;i++) {
					var r = rows[i].childNodes;
					var listRow = [];
					listRow.push(r[1].innerHTML);
					
					var mark = r[3].childNodes[0].value;
					if (mark=="") {
						listRow.push(-1);
					}else{
						listRow.push(mark);
					}
					listRow.push(r[5].childNodes[0].value);
					list.push(JSON.stringify(listRow));
				}
				
				$.ajax({
					type : "post",
					url : "/maven-web-demo/assignment/SubmitMark",
					data : {
						assignmentid:"${assignmentid}",
						content:document.getElementById("reportcontent").value,
						list:JSON.stringify(list)
					},
					dataType : "json",
					success : function(data) {
						if (data == "success") {
							alert("提交报告成功");
							window.location.href="/maven-web-demo/assignment/SubmitReport.action?cid=${cid}";
						}else {
							alert("提交报告失败：系统异常。")
						}
					},
					error : function() {
						alert("系统异常，请稍后重试！")
					}
				});
			})
		}

		function format(date) {
			return date.substring(0, 10);
		}
	</script>	
	
<%@ include  file="footer.jsp"%>
</body>
</html>	
