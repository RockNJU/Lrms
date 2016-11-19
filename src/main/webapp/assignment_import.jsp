<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>导入风险</title>
<%@ include  file="meta_and_script.jsp"%>
<script src="/maven-web-demo/js/calendar.js"></script>
<script src="/maven-web-demo/js/mysift.js" ></script>
<script>

	var cid = ${cid};
	var authority = ${authority};

	var startCalendar = new Calendar("startCalendar");
	var endCalendar = new Calendar("endCalendar");
	document.write(startCalendar);
	document.write(endCalendar);
	
	function query() {
		var start = $("input[name=startDate]").val();
		var end = $("input[name=endDate]").val();

		$.ajax({
			type : "get",
			url : "/maven-web-demo/assignment/GetRecommendAssignments",
			data : {
				startDate:start,
				endDate:end,
				cid:cid
			},
			dataType : "json",
			success : function(data) {
				fillRecommendRecoTable(data[0]);
				fillRecommendProbTable(data[1]);
			},
			error: function() {
				alert("系统异常，请稍后重试！");
            },
		});
	}


</script>
</head>
<body>
<%@ include  file="navigation.jsp"%>
	<div class="admission">
	   <div class="container">
	   	  <h2>导入风险</h2>

			<div class="col-md-3 admission_left">
	             <div class="input-group input-group1">
	                <input type="text"  name="startDate" placeholder="开始日期" onfocus="startCalendar.showMoreDay = false;startCalendar.show(this);"
									class="frm-field required" />
	             </div>
	             <div class="input-group input-group1">
	                 <input type="text" name="endDate"  placeholder="结束日期" onfocus="endCalendar.showMoreDay = false;endCalendar.show(this);"
									class="frm-field required" />
	             </div>

				<input type="submit" value="查询推荐风险" id="queryBtn" class="course-submit-wide" onclick="query()" />
			</div>
			
			<br/>
			
			<br/>
			
			<div class="clearfix"> </div>
			<h3>被识别最多的风险</h3>	       
	      <div class="clearfix"> </div>
	   	  <table class="timetable" id="recommendRecoTable">
							    <thead>
									<tr>
										<th>标题</th>	
										<th>内容</th>
										<th>可能性</th>  
										<th>影响程度</th>
										<th>触发器</th> 
										<th>提交者</th>
										<th>提交时间</th>
										<th>次数</th>
										<th>导入</th>
								    </tr>
								</thead>
			</table>
			<br/>
			<br/>
		   <div class="clearfix"> </div>
		   
		   <h3>演变为问题最多的风险</h3>	 
		  <div class="clearfix"> </div>
	   	  <table class="timetable" id="recommendProbTable">
							    <thead>
									<tr>
										<th>标题</th>	
										<th>内容</th>
										<th>可能性</th>  
										<th>影响程度</th>
										<th>触发器</th> 
										<th>提交者</th>
										<th>提交时间</th>
										<th>次数</th>
										<th>导入</th>
								    </tr>
								</thead>
			</table>
			<br/>
			<br/>
		   <div class="clearfix"> </div>
		   
	   	   <h3>所有可导入风险</h3>	 
	   	  <div class="clearfix"> </div>
	   	  <table class="timetable" id="allTable">
							    <thead>
									<tr>
										<th>标题</th>	
										<th>内容</th>
										<th>可能性</th>  
										<th>影响程度</th>
										<th>触发器</th> 
										<th>提交者</th>
										<th>提交时间</th>
										<th>导入</th>
								    </tr>
								</thead>
			</table>
		   <div class="clearfix"> </div>
				
				
	       
	       <script>
	       
	       
	   	
	   	

	   	refreshAllTable();
	   	
	   	

   		function refreshAllTable() {
   			$.ajax({
   				type : "get",
   				url : "/maven-web-demo/assignment/GetAssignmentsToImport",
   				data : {
   					cid: cid
   				},
   				dataType : "json",
   				success : function(data) {
   					fillAllTable(data);
   				},
   				error : function() {
   					alert("系统异常，请稍后重试！")
   				}
   			});
   		}
	   	



	   		
	   		function fillAllTable(data) {
	   			var table = document.getElementById("allTable");
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
	   				
	   				var importBtn = document.createElement("input");
	   				importBtn.setAttribute("type", "button");
	   				importBtn.setAttribute("name", ass.assignmentid);
	   				importBtn.setAttribute("value", "导入");
	   				importBtn.setAttribute("class", "course-submit");
	   				importBtn.setAttribute("onclick", "importAssignment(this)");
	   				row.insertCell(7).appendChild(importBtn);
	   			}
	   		}
	   		
	   		
	   		function fillRecommendRecoTable(data) {
	   			var table = document.getElementById("recommendRecoTable");
	   			var rowNum = table.rows.length;
	   			for (var i = 1; i < rowNum; i++) {
	   				table.deleteRow(i);
	   				rowNum = rowNum - 1;
	   				i = i - 1;
	   			}
	   			var count=data.length;
	   			for (var i = 0; i < count; i++) {
	   				var ass = data[i].assignment;
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
	   				row.insertCell(7).appendChild(
	   						document.createTextNode(data[i].count));
	   				
	   				var importBtn = document.createElement("input");
	   				importBtn.setAttribute("type", "button");
	   				importBtn.setAttribute("name", ass.assignmentid);
	   				importBtn.setAttribute("value", "导入");
	   				importBtn.setAttribute("class", "course-submit");
	   				importBtn.setAttribute("onclick", "importAssignment(this)");
	   				row.insertCell(8).appendChild(importBtn);
	   			}
	   		}
	   		
	   		function fillRecommendProbTable(data) {
	   			var table = document.getElementById("recommendProbTable");
	   			var rowNum = table.rows.length;
	   			for (var i = 1; i < rowNum; i++) {
	   				table.deleteRow(i);
	   				rowNum = rowNum - 1;
	   				i = i - 1;
	   			}
	   			var count=data.length;
	   			for (var i = 0; i < count; i++) {
	   				var ass = data[i].assignment;
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
	   				row.insertCell(7).appendChild(
	   						document.createTextNode(data[i].count));
	   				
	   				var importBtn = document.createElement("input");
	   				importBtn.setAttribute("type", "button");
	   				importBtn.setAttribute("name", ass.assignmentid);
	   				importBtn.setAttribute("value", "导入");
	   				importBtn.setAttribute("class", "course-submit");
	   				importBtn.setAttribute("onclick", "importAssignment(this)");
	   				row.insertCell(8).appendChild(importBtn);
	   			}
	   		}

	   		
	   		function importAssignment(btn) {
	   			var assignmentid = btn.name;
	   			$.ajax({
	   				type : "post",
	   				url : "/maven-web-demo/assignment/ImportAssignment",
	   				data : {
	   					cid:cid,
	   					assignmentid:assignmentid
	   				},
	   				dataType : "json",
	   				success : function(data) {
	   					if (data == "success") {
	   						alert("导入成功");
	   						window.location.href="/maven-web-demo/assignment/AssignmentsPage.action?authority=" + authority + "&cid=" +cid;
	   					}else {
	   						alert("导入失败：系统异常。")
	   					}
	   				},
	   				error : function() {
	   					alert("系统异常，请稍后重试！")
	   				}
	   			});
	   		}
	   		
	   		function format(date) {
	   			return date.substring(0,10);
	   		}
	   	
	       </script>

	   </div>
	</div>

	
<%@ include  file="footer.jsp"%>
</body>
</html>	
