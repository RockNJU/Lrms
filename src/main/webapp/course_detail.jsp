<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>项目主页</title>
<%@ include  file="meta_and_script.jsp"%>
</head>
<body>
<%@ include  file="navigation.jsp"%>
	<div class="courses_box1">
	   <div class="container">
	   
		<%@include file="sidebar.jsp"%>
		
		<div class="col-md-9 detail">
			<h3>${course.coursename}</h3>

			
			
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                               <i class="fa fa-bookmark-o icon_3"></i>基本信息
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne" aria-expanded="true">
                        <div class="panel-body">
                            <p>风险评估等级：${course.credit}</p>
							<p>项目描述：${course.description}</p>
                        </div>
                    </div>
                </div>
                                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingFour">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                <i class="fa fa-clock-o icon_3"></i> 项目状态
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour" aria-expanded="false" style="height: 0px;">
                        <div class="panel-body">
                            <c:if test="${course.state eq 0}">
                            	<p style="color:green">未开始</p>
                            </c:if>
                            <c:if test="${course.state eq 1}">
                            	<p style="color:blue">进行中</p>
                            </c:if>
                            <c:if test="${course.state eq 2}">
                            	<p style="color:red">已关闭</p>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a href="#" onclick="gotoAssignmentManage()">
                                <i class="fa fa-pencil-square-o icon_3"></i> 项目风险
                            </a>
                        </h4>
                    </div>
                </div>
                
                <c:if test="${authority eq 0 }">
                 <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTen">
                        <h4 class="panel-title">
                            <a href="#" onclick="gotoSelectionManage()">
                                <i class="fa fa-users icon_3"></i> 参与者管理
                            </a>
                        </h4>
                    </div>
                </div>
                </c:if>
                
                
                <c:if test="${authority eq 999 }">
                 <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTen">
                        <h4 class="panel-title">
                            <a href="#" onclick="gotoAssistManage()">
                                <i class="fa fa-legal icon_3"></i> 助教管理
                            </a>
                        </h4>
                    </div>
                </div>
                </c:if>
                

                <c:if test="${authority eq 999 }">
                 <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwenty">
                        <h4 class="panel-title">
                            <a href="#" onclick="downloadExcel()">
                                <i class="fa fa-barcode icon_3"></i> 项目总结
                            </a>
                        </h4>
                    </div>
                </div>
                </c:if>
              </div>
		  </div>
	   </div>
	</div>
	
	<script>
	function downloadExcel() {
		<c:if test="${course.state eq 0}">
    	alert("不能下载总结：项目尚未结束。");
	</c:if>
	<c:if test="${course.state eq 1}">
	alert("不能下载总结：项目尚未结束。");
	</c:if>
	<c:if test="${course.state eq 2}">
		$.ajax({
			type : "post",
			url : "/maven-web-demo/mycourse/GetExcel",
			timeout : 10000,
			data : {
				
			},
			dataType : "json",
			success : function(data) {
				window.location.href = "/maven-web-demo/download/FileDownload.action?uri=" + data;
			},
	});
		
	</c:if>
	}
	
	function gotoAssignmentManage() {
		<c:if test="${course.state eq 0}">
    	alert("不能查看风险：项目尚未开始。");
	</c:if>
	<c:if test="${course.state eq 1}">
		window.location.href="/maven-web-demo/assignment/AssignmentsPage.action?authority=${authority}&cid=${course.cid}";
	</c:if>
	<c:if test="${course.state eq 2}">
		window.location.href="/maven-web-demo/assignment/AssignmentsPage.action?authority=${authority}&cid=${course.cid}";
	</c:if>
	}
	
	function gotoSelectionManage() {
        <c:if test="${course.state eq 0}">
        	window.location.href="/maven-web-demo/teachcourse/SelectionManagePage.action?cid=${course.cid}";
    	</c:if>
    	<c:if test="${course.state eq 1}">
    		window.location.href="/maven-web-demo/teachcourse/SelectionManagePage.action?cid=${course.cid}";
    	</c:if>
    	<c:if test="${course.state eq 2}">
    		alert("不能安排添加参与者：项目已经关闭");
    	</c:if>
	}
	
	function gotoAssistManage() {
        <c:if test="${course.state eq 0}">
    		window.location.href="/maven-web-demo/teachcourse/AssistManagePage.action?cid=${course.cid}";
		</c:if>
		<c:if test="${course.state eq 1}">
			window.location.href="/maven-web-demo/teachcourse/AssistManagePage.action?cid=${course.cid}";
		</c:if>
		<c:if test="${course.state eq 2}">
			alert("不能安排助教：项目已经关闭");
		</c:if>		
	}
	
	</script>
	
<%@ include  file="footer.jsp"%>

</body>
</html>	
