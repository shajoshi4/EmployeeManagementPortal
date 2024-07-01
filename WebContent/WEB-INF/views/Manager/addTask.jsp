 <%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Employee</title>
<link href="<spring:url value='/bootstrap/css/bootstrap.css'/>"
	type="text/css" rel="stylesheet" />
</head>
<body>
	
<div class="container">
		<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headermgr.jsp"></jsp:include>
		</div><br><br><br><br><br>

<form:form action="addTask" modelAttribute="task" enctype="multipart/form-data">

	<div class="form-group row">
				<label for="description" class="col-sm-2 col-form-label">Description</label>
				<div class="col-sm-4">
					<form:textarea path="description" class="form-control"
						id="description" autofocus="true" placeholder="Eg:Write here... "/>
				</div>
			</div>
			
			<div class="form-group row" >			
				Choose File to Upload : <input type="file" name="fileUpload" /> 
			</div>
			
			
			
	<div class="form-group row">
				<label for="deadline" class="col-sm-2 col-form-label">Deadline</label>
				<div class="col-sm-4">
					<form:input type="date" path="deadline" class="form-control"
						id="deadline" placeholder="12-12-2018"/>
				</div>
			</div>
			
			
			
	<div class="form-group row">
				<label for="employees" class="col-sm-2 col-form-label">Employee ID</label>
				<div class="col-sm-4">
					<form:select  path="allocatedTo.empId" class="form-control" id="employees">
								<form:options var="emp" items="${requestScope.empList}" value="${emp.empId}"></form:options>
					</form:select>
				</div>
			</div>
	
	
	
					
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" name="btn" value="Register"
						class="btn btn-info">Register</button>
				</div>
				<div class="offset-sm-2 col-sm-10">
					<button type="reset" name="btn" value="Reset"
						class="btn btn-info">Reset</button>
				</div>
			</div>
</form:form>
</div>
	<script src="<spring:url value='/js/jquery.1.9.1.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/js/bootstrap.min.js'/>"></script>

</body>
</html>