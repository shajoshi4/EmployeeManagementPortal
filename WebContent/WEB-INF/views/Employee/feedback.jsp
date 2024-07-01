<%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Feedback</title>
<link href="<spring:url value='/bootstrap/css/bootstrap.css'/>"
	type="text/css" rel="stylesheet" />
</head>
<body>
<div class="container">
	<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headeremp.jsp"></jsp:include>
		</div><br><br><br>

	<form:form action="feedback" method="POST" modelAttribute="feed">
	
		<div class="form-group row">
			<label for="inputemp" class="col-sm-2 col-form-label">Employee Id:</label>
				<div class="col-sm-4">
					<form:input type="text" value="${sessionScope.user.empId}" readonly="true" path="person.empId" class="form-control" id="inputemp"/>
				</div>
		</div>
	
		<div class="form-group row">
			<label for="inputque1" class="col-sm-2 col-form-label">What do you think of the company environment</label>
				<div class="col-sm-4">
					<form:input type="text" path="que1" class="form-control" id="inputque1" min="1" max="10"/>
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputque2" class="col-sm-2 col-form-label">Do you like the food served in the canteen</label>
				<div class="col-sm-4">
					<form:input type="text" path="que2" class="form-control" id="inputque2" min="1" max="10"/>
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputque3" class="col-sm-2 col-form-label">Do you like the office infrastructure</label>
				<div class="col-sm-4">
					<form:input type="text" path="que3" class="form-control" id="inputque3" min="1" max="10"/>
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputque4" class="col-sm-2 col-form-label">What do you think about the perks provided to you</label>
				<div class="col-sm-4">
					<form:input type="text" path="que4" class="form-control" id="inputque4" min="1" max="10"/>
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputque5" class="col-sm-2 col-form-label">What do you think about the HR policy</label>
				<div class="col-sm-4">
					<form:input type="text" path="que5" class="form-control" id="inputque5" min="1" max="10"/>
				</div>
		</div>
		<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" name="btn" value="Submit"
						class="btn btn-info">Submit Feedback</button>
				</div>
		</div>
		
		<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="reset" name="btn" value="reset"
						class="btn btn-info">Clear</button>
				</div>
		</div>
	</form:form>
	</div>
</body>
</html>