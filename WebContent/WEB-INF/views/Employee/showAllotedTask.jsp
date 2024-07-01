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
			<jsp:include page="/WEB-INF/views/Master/_headeremp.jsp"></jsp:include>
		</div><br><br><br><br><br>
		<h1 align="center">Allocated Tasks</h1>
		<table class="table table-bordered" border="1">
			<tr class="info">
				<td>Task Id</td><td>Task File</td><td>Description</td><td>Allocated On</td><td>Deadline</td><td>Download</td><td>Submit</td>
			</tr>
			<c:forEach var="task" items="${requestScope.list}" >
					<tr class="info">
					<td>${task.taskId}</td>
					<td>${task.taskFile}</td>
					<td>${task.description}</td>
					<td>${task.allocatedOn}</td>
					<td>${task.deadline}</td>
					<form:form  method="POST" action="submitTask" enctype="multipart/form-data">
					
					<td>
					<div class="form-group row" >			
					Choose File to Upload : <input type="file" name="fileUpload" />
					<input type="hidden" name="taskId"  value="${task.taskId}"/>
					<input type="hidden" name="empId"  value="${task.allocatedBy.empId}"/>
					<input type="submit" value="Submit Task"/>
					</div>
					</td>
					</form:form>
					
					<td><a href="downloadTask?taskId=${task.taskId}&taskFileNm=${task.taskFile}">Download</a></td>
					
					</tr>
			</c:forEach>
		</table>
		</div>
</body>
</html>