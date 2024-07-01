 <%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="<spring:url value='/bootstrap/css/bootstrap.css'/>"
	type="text/css" rel="stylesheet" />
<body>
<div class="container">
	<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headermgr.jsp"></jsp:include>
		</div><br><br><br><br><br>

<form:form  enctype="multipart/form-data">

		<h1 align="center">Submitted Tasks</h1>
		<table class="table table-bordered" border="1">
			<tr class="info">
				<td>Task Id</td><td>Task File</td><td>Description</td><td>Allocated On</td><td>Deadline</td><td>Submitted On</td>
				<td>Download</td><td>Successfully Completed</td><td>Reassign Task</td>
			</tr>
			<c:forEach var="task" items="${requestScope.tasks}">
					<tr class="info">
					<td>${task.taskId}</td>
					<td>${task.responseFile}</td>
					<td>${task.description}</td>
					<td>${task.allocatedOn}</td>
					<td>${task.deadline}</td>
					<td>${task.submittedOn}</td>
					<td><a href="downloadSubmitedTask?taskFileNm=${task.responseFile}">Download</a></td>
					<td><a href="taskSetToSuccessful?taskId=${task.taskId}">Successfully Completed </a></td>
					<td><a href="taskSetToReassigned?taskId=${task.taskId}">Reassign Task </a></td>
					
					
					</tr>
			</c:forEach>
		</table>
</form:form>
</div>
</body>
</html>