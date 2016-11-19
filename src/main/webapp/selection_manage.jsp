<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>参与者管理</title>
<%@ include file="meta_and_script.jsp"%>
<script src="/maven-web-demo/js/mysift.js" ></script>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<div class="courses_box1">
		<div class="container" id="container">
		
		<h3>参与者管理</h3>
			
			<div id="student-form">
			<!-- 输入参与者 -->
				<div class="input-group input-group1">
						<input type="text" style="display:none;" />	<!-- 防止回车自动提交 -->
				</div>
				<div class="input-group input-group1" >
						<input class="form-control has-dark-background" name="student-uid" placeholder="添加参与者（选择后按回车添加多个参与者）"
											type="text" id="student0"/>
				</div>
			</div>
						<input  class="course-submit-wide" type="button" value="添加" id="addBtn" onclick="return false" />
			
						<br/><br/>
						
			
			
			<table class="timetable" id="selectedTable">
				<thead>
					<tr>
						<th>工号</th>
						<th>姓名</th>
						<th>联系电话</th>
						<th>电子邮箱</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody id="tbd">
				</tbody>
			</table>

		</div>
	</div>

	<script>
	
	var cid = ${cid};
	
	var studentinfo = [];
	var studentids = [];
	var dropdowns = [];
	var dropdownCount = 1;
	
	refreshCandidateAndBindFirstText();
	addBtn();
	batchBtn();
	refreshSelectedTable();
	
	function batchBtn() {
		var $btn = $("#batchbtn");
		$btn.bind(
						"click",
						function() {
							$.ajax({
										type : "post",
										url : "/maven-web-demo/teachcourse/BatchSelection",
										timeout : 10000,
										data : {
											cid:cid,
											startuid:$("input[name=startuid]").val(),
											enduid: $("input[name=enduid]").val()
										},
										dataType : "json",
										success : function(data) {
											alert(data);
										},
										error : function() {
											alert("系统异常，请稍后重试！")
										}
									});
						})
	}
	
	
	
	
	function refreshCandidateAndBindFirstText() {
		$.ajax({
			type : "post",
			url : "/maven-web-demo/teachcourse/GetStudentToSelect",
			data : {
				cid:cid
			},
			dataType : "json",
			success : function(data) {
				studentinfo = [];
				studentids = [];
				dropdowns = [];
				for (var i=0; i< data.length ; i++) {
					studentinfo.push(data[i].uid + "         " + data[i].username );
					studentids.push(data[i].uid);
				}
				dropdowns.push(new mSift('dropdowns[0]', 20));
				//数据 
				dropdowns[0].Data = studentinfo;
				dropdowns[0].Ids = studentids;
				//指定文本框对象建立特效 
				dropdowns[0].Create(document.getElementById('student0'));
				dropdownCount = 1;
				$("#student0").bind("keydown", function (e) {
					var curKey = e.which;
					if (curKey == 13) {
						addNewText();
						document.getElementById("student-form").lastChild.lastChild.focus();
					}
				});
			},
			error: function() {
				alert("系统异常，请稍后重试！");
            },
		});
	}

	function addNewText() {
		var div = document.createElement("div");
		div.setAttribute("class", "input-group input-group1");
		var text = document.createElement("input");
		text.setAttribute("class", "form-control has-dark-background");
		text.setAttribute("placeholder", "添加参与者（选择后按回车添加多个参与者）");
		text.setAttribute("type", "text");
		$(text).bind("keydown", function (e) {
			var curKey = e.which;
			if (curKey == 13) {
				addNewText();
				document.getElementById("student-form").lastChild.lastChild.focus();
			}
		});
		div.appendChild(text);
		$("#student-form").append(div);
		
		dropdowns.push(new mSift('dropdowns[' + dropdownCount + ']', 20));
		//数据 
		dropdowns[dropdownCount].Data = studentinfo;
		dropdowns[dropdownCount].Ids = studentids;
		//指定文本框对象建立特效 
		dropdowns[dropdownCount].Create(text);
		dropdownCount++;
	}
	
	function removeTexts() {
		document.getElementById("container").removeChild(document.getElementById("student-form"));
		var form = document.createElement("div");
		form.setAttribute("id", "student-form");
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
		text2.setAttribute("id", "student0");
		text2.setAttribute("class", "form-control has-dark-background");
		text2.setAttribute("placeholder", "添加参与者（选择后按回车添加多个参与者）");
		text2.setAttribute("type", "text");
		div2.appendChild(text2);
		form.appendChild(div2);
		
		document.getElementById("container").insertBefore(form, document.getElementById("addBtn"));
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
				var cid = ${requestScope.cid};
				var uid = list.join("-");
				$.ajax({
					type : "post",
					url : "/maven-web-demo/teachcourse/AddSelection",
					data : {
						uid:uid,
						cid:cid
					},
					dataType : "json",
					success : function(data) {
						alert(data);
						removeTexts();
						refreshCandidateAndBindFirstText();
						refreshSelectedTable();
					},
					error: function() {
						alert("系统异常，请稍后重试！");
                    },
				});
			})
		}
		
		function fillSelectedTable(data) {
			var table = document.getElementById("selectedTable");
			var rowNum = table.rows.length;
			for (var i = 1; i < rowNum; i++) {
				table.deleteRow(i);
				rowNum = rowNum - 1;
				i = i - 1;
			}
			var count=data.length;
			for (var i = 0; i < count; i++) {
				var user = data[i];
				var row = table.insertRow();
				row.insertCell(0)
						.appendChild(document.createTextNode(user.uid));
				row.insertCell(1).appendChild(
						document.createTextNode(user.username));
				if (user.tel == null) {
					row.insertCell(2).appendChild(
							document.createTextNode(""));
				}else {
					row.insertCell(2).appendChild(
							document.createTextNode(user.tel));
				}
				if (user.email == null) {
					row.insertCell(3).appendChild(
							document.createTextNode(""));
				}else {
					row.insertCell(3).appendChild(
							document.createTextNode(user.email));
				}
				
				
				
				
				var delBtn = document.createElement("input");
				delBtn.setAttribute("type", "button");
				delBtn.setAttribute("id", user.uid);
				delBtn.setAttribute("value", "删除");
				delBtn.setAttribute("class", "course-submit");
				delBtn.setAttribute("onclick", "delSelected(this)");
				row.insertCell(4).appendChild(delBtn);
			}
		}

		function refreshSelectedTable() {
			$.ajax({
				type : "get",
				url : "/maven-web-demo/teachcourse/GetSelectedStudent",
				data : {
					cid: cid
				},
				dataType : "json",
				success : function(data) {
					fillSelectedTable(data);
				},
				error : function() {
					alert("系统异常，请稍后重试！")
				}
			});
		}
		
		function delSelected(btn) {
			var uid = btn.id;
			var cid = ${requestScope.cid};
			$.ajax({
				type : "post",
				url : "/maven-web-demo/teachcourse/DelSelection",
				data : {
					cid: cid,
					uid:uid
				},
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						alert("删除成功");
						refreshSelectedTable();
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
