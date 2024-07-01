<%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
<link href="<spring:url value='/bootstrap/css/bootstrap.css'/>"
	type="text/css" rel="stylesheet" />

</head>
<body>
<div class="container">

		<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headermgr.jsp"></jsp:include>
		</div><br><br><br><br><br>
		<form:form action="addNotice" method = "POST" modelAttribute="notice">
		
		<div class="form-group row">
				<label for="inputnoticeText" class="col-sm-2 col-form-label">Notice Text:</label>
				<div class="col-sm-4">
					<form:input type="text"  path="noticeText"  class="form-control"
						id="inputnoticeText" autofocus="true" required="true" placeholder="Enter Notice Text"/>
				</div>
			</div>

			<div class="form-group row">
				<label for="inputmgrId" class="col-sm-2 col-form-label">Department Id</label>
				<div class="col-sm-4">
					<form:input type="text" value="${sessionScope.user.dept.deptId}" path="dept.deptId" class="form-control" id="inputmgrId"
						readonly="true"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label for="inputempId" class="col-sm-2 col-form-label">Manager ID:</label>
				<div class="col-sm-4">
					<form:input type="text" value="${sessionScope.user.empId}" path="manager.empId" class="form-control" id="inputempId"
					 readonly="true"/>
				</div>
			</div>
			
			
			
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="Submit" name="btn" value="Cancel"
						class="btn btn-info">Submit</button>
				</div>
				
			</div>
			
		</form:form>
		
	</div>

	<!-- jQuery 1.9 -->
	<%--Bootstrap JS --%>
	<script src="<spring:url value='/js/jquery.1.9.1.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
</body>
</html>