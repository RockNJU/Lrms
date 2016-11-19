<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>学期管理</title>
<%@ include file="meta_and_script.jsp"%>
<script src="/maven-web-demo/js/calendar.js"></script>
<script>
	var startCalendar = new Calendar("startCalendar");
	var endCalendar = new Calendar("endCalendar");
	document.write(startCalendar);
	document.write(endCalendar);
</script>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<div class="courses_box1">
		<div class="container">
		
			   	  <div class="col-md-6 admission_left">
             <div class="input-group input-group1">
                <input class="form-control has-dark-background"
									name="semesterName"  placeholder="学期名称" type="text">
             </div>
             <div class="input-group input-group1">
                <input class="form-control has-dark-background"
									name="comment" placeholder="备注"
									type="text">
             </div>
             <input type="submit" value="发布" id="addBtn" class="course-submit-wide" />
           </div>

            <div class="col-md-6 admission_right">
	             <div class="input-group input-group1">
	                <input type="text"  name="startDate" placeholder="学期开始日期" onfocus="startCalendar.showMoreDay = false;startCalendar.show(this);"
									class="frm-field required" />
	             </div>
	             <div class="input-group input-group1">
	                 <input type="text" name="endDate"  placeholder="学期结束日期" onfocus="endCalendar.showMoreDay = false;endCalendar.show(this);"
									class="frm-field required" />
	             </div>
	       </div>	
	       

			<table class="timetable" id="semesterTable">
				<thead>
					<tr>
						<th>学期名称</th>
						<th>开始日期</th>
						<th>结束日期</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody id="tbd">
				</tbody>
			</table>
			</div>
			</div>

	<script>
		function addBtn() {
			var $btn = $("#addBtn");
			$btn.bind("click", function() {
				var start = $("input[name=startDate]").val();
				var end = $("input[name=endDate]").val();
				$.ajax({
					type : "post",
					url : "semester/AddSemester",
					data : {
						semestername: $("input[name=semesterName]").val(),
						startDate:start,
						endDate:end,
						comment: $("input[name=comment]").val(),
					},
					dataType : "json",
					success : function(data) {
						if (data=="success") {
							alert("添加成功！");
							refreshSemesterTable();
						}else {
							alert("添加失败：请检查输入。")
						}
					},
					error: function() {
						alert("系统异常，请稍后重试！");
                    },
				});
			})
		}
		
		function fillSemesterTable(data) {
			var table = document.getElementById("semesterTable");
			var rowNum = table.rows.length;
			for (var i = 1; i < rowNum; i++) {
				table.deleteRow(i);
				rowNum = rowNum - 1;
				i = i - 1;
			}
			var count=data.length;
			for (var i = 0; i < count; i++) {
				var semester = data[i];
				var row = table.insertRow();
				row.insertCell(0)
						.appendChild(document.createTextNode(semester.semestername));
				row.insertCell(1).appendChild(
						document.createTextNode(semester.startDate));
				row.insertCell(2).appendChild(
						document.createTextNode(semester.endDate));
				row.insertCell(3)
						.appendChild(document.createTextNode(semester.comment));
			}
		}

		function refreshSemesterTable() {
			$.ajax({
				type : "get",
				url : "semester/GetSemester",
				data : {},
				dataType : "json",
				success : function(data) {
					fillSemesterTable(data);
				},
				error : function() {
					alert("系统异常，请稍后重试！")
				}
			});
		}

		$(document).ready(
				function() {
					refreshSemesterTable();
					addBtn();
				});
	</script>


	<%@ include file="footer.jsp"%>
</body>
</html>
