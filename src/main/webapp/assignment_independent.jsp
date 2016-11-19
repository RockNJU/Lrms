<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>风险管理</title>
<%@ include  file="meta_and_script.jsp"%>
<script src="/maven-web-demo/js/mysift.js" ></script>
</head>
<body>
<%@ include  file="navigation.jsp"%>
	<div class="admission">
	   <div class="container">
	   	  <h2>风险发布</h2>
	   	  <div class="col-md-6 admission_left">
             <div class="input-group input-group1">
                <input class="form-control has-dark-background" id="title"  placeholder="标题" type="text" />
             </div>
             <div class="input-group input-group1">
                <input class="form-control has-dark-background" id="content" placeholder="内容" type="text"/>
             </div>
             <div class="input-group input-group1">
                <input class="form-control has-dark-background" id="possibility" placeholder="可能性（高/中/低）" type="text"/>
             </div>
             <div class="input-group input-group1">
                <input class="form-control has-dark-background" id="impact" placeholder="影响程度（高/中/低）" type="text"/>
             </div>
             <div class="input-group input-group1">
                <input class="form-control has-dark-background" id="trig" placeholder="触发器" type="text"/>
             </div>
           </div>
           
           	<!-- 输入跟踪者 -->
			<form id="teacher-form">
				<div class="input-group input-group1">
						<input type="text" style="display:none;" />	<!-- 防止回车自动提交 -->
				</div>
				<div class="input-group input-group1" >
						<input class="form-control has-dark-background" name="teacher-uid" placeholder="添加跟踪者"
											type="text" id="teacher0"/>
				</div>
			</form>

            <div class="col-md-6 admission_right">
	            <input type="submit" value="发布" id="addBtn" class="course-submit-wide" />
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
	   	refreshAssignmentTable();
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
	   		text.setAttribute("placeholder", "添加跟踪者");
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
	   			var title = $("#title").val();
	   			var content = $("#content").val();
	   			var possibility = $("#possibility").val();
	   			var impact = $("#impact").val();
	   			var trig = $("#trig").val();
	   			$.ajax({
	   				type : "post",
	   				url : "/maven-web-demo/assignment/AddAssignment",
	   				data : {
	   					cid:-1,
	   					title:title,
	   					content:content,
	   					possibility:possibility,
	   					impact:impact,
	   					trig:trig,
	   					followers:list.join("-")
	   				},
	   				dataType : "json",
	   				success : function(data) {
	   					if (data=="success") {
	   						alert("发布成功！");
	   						window.location.reload(true);
	   					}else {
	   						alert("发布失败：请检查输入。");
	   					}
	   				},
	   				error: function() {
	   					alert("系统异常，请稍后重试！");
	                   },
	   			});
	   		})
	   	}


	   		
	   		function fillAssignmentTable(data) {
	   			var table = document.getElementById("assignmentTable");
	   			var rowNum = table.rows.length;
	   			for (var i = 1; i < rowNum; i++) {
	   				table.deleteRow(i);
	   				rowNum = rowNum - 1;
	   				i = i - 1;
	   			}
	   			var count=data.length;
	   			for (var i = 0; i < count; i++) {
	   				var ass = data[i];
	   				var row = table.insertRow();
	   				row.insertCell(0)
	   						.appendChild(document.createTextNode(ass.title));
	   				row.insertCell(1).appendChild(
	   						document.createTextNode(ass.content));
	   				row.insertCell(2).appendChild(
	   						document.createTextNode(ass.possibility));
	   				row.insertCell(3).appendChild(
	   						document.createTextNode(ass.impact));
	   				row.insertCell(4).appendChild(
	   						document.createTextNode(ass.trig));
	   				row.insertCell(5).appendChild(
	   						document.createTextNode(ass.submitUid));
	   				row.insertCell(6).appendChild(
	   						document.createTextNode(format(ass.createdAt)));
	   				
	   				var checkBtn = document.createElement("input");
	   				checkBtn.setAttribute("type", "button");
	   				checkBtn.setAttribute("name", ass.assignmentid);
	   				checkBtn.setAttribute("value", "查看");
	   				checkBtn.setAttribute("class", "course-submit");
	   				checkBtn.setAttribute("onclick", "checkMark(this)");
	   				row.insertCell(7).appendChild(checkBtn);
	   				
	   				
	   				
		   				var delBtn = document.createElement("input");
		   				delBtn.setAttribute("type", "button");
		   				delBtn.setAttribute("name", ass.assignmentid);
		   				delBtn.setAttribute("value", "删除");
		   				delBtn.setAttribute("class", "course-submit");
		   				if (ass.submitUid == "${sessionScope.user.uid}") {
		   					delBtn.setAttribute("onclick", "delAssignment(this)");
		   				}
		   				else {
		   					delBtn.setAttribute("onclick", "illegalAlert()");
		   				}
		   				
		   				row.insertCell(8).appendChild(delBtn);
	   				
	   			}
	   		}
	   	
	   		
	   		function illegalAlert() {
	   			alert("操作拒绝：没有权限");
	   		}

	   		function refreshAssignmentTable() {
	   			$.ajax({
	   				type : "get",
	   				url : "/maven-web-demo/assignment/GetAssignments",
	   				data : {
	   					cid: -1
	   				},
	   				dataType : "json",
	   				success : function(data) {
	   					fillAssignmentTable(data);
	   				},
	   				error : function() {
	   					alert("系统异常，请稍后重试！")
	   				}
	   			});
	   		}
	   		
	   		function delAssignment(btn) {
	   			var assignmentid = btn.name;
	   			$.ajax({
	   				type : "post",
	   				url : "/maven-web-demo/assignment/DelAssignment",
	   				data : {
	   					assignmentid:assignmentid
	   				},
	   				dataType : "json",
	   				success : function(data) {
	   					if (data == "success") {
	   						alert("删除成功");
	   						refreshAssignmentTable();
	   					}else {
	   						alert("删除失败：系统异常。")
	   					}
	   				},
	   				error : function() {
	   					alert("系统异常，请稍后重试！")
	   				}
	   			});
	   		}
	   		
	   		
	   		function checkMark(btn) {
	   			var assignmentid = btn.name;
	   			window.location.href="/maven-web-demo/assignment/MarksApprovePage.action?assignmentid=" + assignmentid+"&cid=-1";
	   		}
	   		
	   		function format(date) {
	   			return date.substring(0,10);
	   		}
	   	
	       </script>
	   	   
	   	  <div class="clearfix"> </div>
	   	  <table class="timetable" id="assignmentTable">
							    <thead>
									<tr>
										<th>标题</th>	
										<th>内容</th>
										<th>可能性</th>  
										<th>影响程度</th>
										<th>触发器</th> 
										<th>提交者</th>
										<th>提交时间</th>
										<th>查看状态跟踪</th>
										<th>删除</th>
								    </tr>
								</thead>
			</table>
		   <div class="clearfix"> </div>
	   </div>
	</div>

	
<%@ include  file="footer.jsp"%>
</body>
</html>	
