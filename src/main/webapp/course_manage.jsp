<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>项目管理</title>
<%@ include file="meta_and_script.jsp"%>
<script src="/maven-web-demo/js/mysift.js" ></script>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<div class="courses_box1">
		<div class="container" id="container">
			<form class="contact_form">
				<div class="col-md-6 grid_6"  >
					<input type="text" class="text" name="coursename" id="coursename"
						placeholder="项目名称" />
					 <input type="text" class="text"
						name="credit" id="credit" placeholder="风险评估等级（1/2/3/4/5）" />
				</div>
				<div class="col-md-6 grid_6">
					<textarea style="height:120px" placeholder="项目描述" id="description"></textarea>
				</div>
				<div class="clearfix"></div>
			</form>
			
			<!-- 输入负责人 -->
			<form id="teacher-form">
				<div class="input-group input-group1">
						<input type="text" style="display:none;" />	<!-- 防止回车自动提交 -->
				</div>
				<div class="input-group input-group1" >
						<input class="form-control has-dark-background" name="teacher-uid" placeholder="负责人（选择后按回车添加多个负责人）"
											type="text" id="teacher0"/>
				</div>
			</form>
						<input type="button" value="添加" id="addBtn" class="course-submit-wide" onclick="return false" />
			<table class="timetable" id="courseTable">
				<thead>
					<tr>
						<th>项目名称</th>
						<th>风险评估等级</th>
						<th>项目描述</th>
						<th>负责人</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody id="tbd">
				</tbody>
			</table>

		</div>
	</div>

	<script>
	var teacherinfo = [];
	var teacherids = [];
	var dropdowns = [];
	<c:forEach var="item" items="${teachers}">
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
	refreshCourseTable();
	addBtn();
	
	function bindFirstText() {
		$("#teacher0").bind("keydown", function (e) {
			var curKey = e.which;
			if (curKey == 13) {
				addNewText();
				document.getElementById("teacher-form").lastChild.lastChild.focus();
			}
		});
		dropdowns[0].Create(document.getElementById('teacher0'));
	}

	function addNewText() {
		var div = document.createElement("div");
		div.setAttribute("class", "input-group input-group1");
		var text = document.createElement("input");
		text.setAttribute("class", "form-control has-dark-background");
		text.setAttribute("placeholder", "负责人（选择后按回车添加多个负责人）");
		text.setAttribute("type", "text");
		$(text).bind("keydown", function (e) {
			var curKey = e.which;
			if (curKey == 13) {
				addNewText();
				document.getElementById("teacher-form").lastChild.lastChild.focus();
			}
		});
		div.appendChild(text);
		$("#teacher-form").append(div);
		
		dropdowns.push(new mSift('dropdowns[' + dropdownCount + ']', 20));
		//数据 
		dropdowns[dropdownCount].Data = teacherinfo;
		dropdowns[dropdownCount].Ids = teacherids;
		//指定文本框对象建立特效 
		dropdowns[dropdownCount].Create(text);
		dropdownCount++;
	}
	function removeTexts() {
		document.getElementById("container").removeChild(document.getElementById("teacher-form"));
		var form = document.createElement("form");
		form.setAttribute("id", "teacher-form");
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
		text2.setAttribute("id", "teacher0");
		text2.setAttribute("class", "form-control has-dark-background");
		text2.setAttribute("placeholder", "负责人（选择后按回车添加多个负责人）");
		text2.setAttribute("type", "text");
		div2.appendChild(text2);
		form.appendChild(div2);
		
		document.getElementById("container").insertBefore(form, document.getElementById("addBtn"));
		bindFirstText();
	}
	
	
		function addBtn() {
			var $btn = $("#addBtn");
			$btn.bind("click", function() {
				var list = [];
				for (var i=0;i<dropdowns.length;i++) {
					var selectedId = dropdowns[i].GetSelectedId();
					if (typeof(selectedId) != "undefined" && list.indexOf(selectedId) < 0) {
						list.push(selectedId);
					}
				}
				var name = $("input[name=coursename]").val();
				var credit = $("input[name=credit]").val();
				var description = $("#description").val();
				$.ajax({
					type : "post",
					url : "course/AddCourse",
					data : {
						coursename:name,
						credit:credit,
						description:description,
						teachers:list.join("-")
					},
					dataType : "json",
					success : function(data) {
						if (data=="success") {
							alert("添加成功！");
							window.location.reload(true)
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
		
		function fillCourseTable(data) {
			var table = document.getElementById("courseTable");
			var rowNum = table.rows.length;
			for (var i = 1; i < rowNum; i++) {
				table.deleteRow(i);
				rowNum = rowNum - 1;
				i = i - 1;
			}
			var count=data.length;
			for (var i = 0; i < count; i++) {
				var course = data[i];
				var row = table.insertRow();
				row.insertCell(0)
						.appendChild(document.createTextNode(course.coursename));
				row.insertCell(1).appendChild(
						document.createTextNode(course.credit));
				row.insertCell(2).appendChild(
						document.createTextNode(course.description));
				row.insertCell(3).appendChild(
						document.createTextNode(course.teacher));
				
				var delBtn = document.createElement("input");
				delBtn.setAttribute("type", "button");
				delBtn.setAttribute("id", course.cid);
				delBtn.setAttribute("value", "删除");
				delBtn.setAttribute("class", "course-submit");
				delBtn.setAttribute("onclick", "delCourse(this)");
				row.insertCell(4).appendChild(delBtn);
			}
		}

		function refreshCourseTable() {
			$.ajax({
				type : "get",
				url : "course/GetUnscheduledCourse",
				data : {},
				dataType : "json",
				success : function(data) {
					fillCourseTable(data);
				},
				error : function() {
					alert("系统异常，请稍后重试！")
				}
			});
		}
		
		function delCourse(btn) {
			var cid = btn.id;
			$.ajax({
				type : "post",
				url : "course/DelCourse",
				data : {
					cid: cid,
				},
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						alert("删除成功");
						refreshCourseTable();
					}else {
						alert("删除失败：系统异常。")
					}
				},
				error : function() {
					alert("系统异常，请稍后重试！")
				}
			});
		}
	</script>

	<%@ include file="footer.jsp"%>
</body>
</html>
