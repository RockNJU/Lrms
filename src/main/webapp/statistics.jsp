<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>统计数据</title>
<%@ include file="meta_and_script.jsp"%>
<script src="/maven-web-demo/js/calendar.js"></script>
<script src="/maven-web-demo/js/highcharts.js"></script>
<script>
	var startCalendar = new Calendar("startCalendar");
	var endCalendar = new Calendar("endCalendar");
	document.write(startCalendar);
	document.write(endCalendar);
</script>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<div class="admission">
		<div class="container">
			<h2>统计数据</h2>

			<div class="col-md-3 admission_left">
	             <div class="input-group input-group1">
	                <input type="text"  name="startDate" placeholder="开始日期" onfocus="startCalendar.showMoreDay = false;startCalendar.show(this);"
									class="frm-field required" />
	             </div>
	             <div class="input-group input-group1">
	                 <input type="text" name="endDate"  placeholder="结束日期" onfocus="endCalendar.showMoreDay = false;endCalendar.show(this);"
									class="frm-field required" />
	             </div>

				<input type="submit" value="查询" id="queryBtn" class="course-submit-wide" onclick="query()" />
			</div>

			<div class="col-md-9 admission_right">
									<!-- 选项卡栏目 -->
						<ul id="myTab" class="nav nav-tabs nav-tabs1" role="tablist">
							<li role="presentation" class="active"><a href="#assignments"
								id="assignments-tab" role="tab" data-toggle="tab"
								aria-controls="assignments" aria-expanded="true">识别最多</a></li>
							<li role="presentation"><a href="#students" role="tab"
								id="students-tab" data-toggle="tab" aria-controls="students">问题最多</a>
							</li>
						</ul>

						<div id="myTabContent" class="tab-content">
						
							<!-- 第一个选项卡 -->
							<div role="tabpanel" class="tab-pane fade in active" id="assignments" aria-labelledby="assignments">
								<div id="assignmentsChartContainer" style="height:400px;width:60%;"></div>
							</div>

							<!-- 第二个选项卡内容 -->
							<div role="tabpanel" class="tab-pane fade" id="students" aria-labelledby="students-tab">
								<div id="studentsChartContainer" style="height:400px;width:60%; "></div>
							</div>
					</div>

			<div class="clearfix"></div>
		</div>
	</div>
	</div>


	<script>


		
		function query() {
			var start = $("input[name=startDate]").val();
			var end = $("input[name=endDate]").val();

			$.ajax({
				type : "get",
				url : "/maven-web-demo/statistics/GetStatistics",
				data : {
					startDate:start,
					endDate:end
				},
				dataType : "json",
				success : function(data) {
				
					refreshAssignmentsChart(data[0]);
					refreshStudentsChart(data[1]);
				},
				error: function() {
					alert("系统异常，请稍后重试！");
                },
			});
		}
		
		function refreshAssignmentsChart(data) {
			var categories = [];
			var expects = [];
			var expectsMap = {};
			for (var i = 0 ; i< data.length; i++) {
				var vo = data[i];
				categories.push(vo.assignment.title);
				expects.push(vo.count);
			}
			expectsMap['name']="被识别次数";
			expectsMap['data']=expects;
			
			$(function () { 
			    $('#assignmentsChartContainer').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: '风险被识别次数'
			        },
			        xAxis: {
			            categories: categories
			        },
			        yAxis: {
			            title: {
			                text: '数量'
			            }
			        },
			        series: [expectsMap]
			    });
			});
		}

		function refreshStudentsChart(data) {
			var categories = [];
			var max = [];
			var maxMap = {};
			for (var i = 0 ; i< data.length; i++) {
				var vo = data[i];
				categories.push(vo.assignment.title);
				max.push(vo.count);
			}
			maxMap['name']="演变成问题数";
			maxMap['data']=max;
			
			$(function () { 
			    $('#studentsChartContainer').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: '演变成问题数'
			        },
			        xAxis: {
			            categories: categories
			        },
			        yAxis: {
			            title: {
			                text: '数量'
			            }
			        },
			        series: [maxMap]
			    });
			});
		}


		function format(date) {
			return date.substring(0,10);
		}
		
		
	</script>

	<%@ include file="footer.jsp"%>
</body>
</html>
