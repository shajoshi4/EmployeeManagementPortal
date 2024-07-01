<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Employee</title>
<link href="<spring:url value='/bootstrap/css/bootstrap.css'/>"
	type="text/css" rel="stylesheet" />
</head>
<body>

<c:choose>
	<c:when test="${sessionScope.designation =='M'}">
	<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headermgr.jsp"></jsp:include>
		</div><br><br>
	</c:when>
	
	<c:otherwise>
	<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headeremp.jsp"></jsp:include>
		</div><br><br>
	</c:otherwise>
</c:choose>
	<form:form action="editProfile" method="POST" modelAttribute="user">
			<div class="form-group row">
			<label for="inputeid" class="col-sm-2 col-form-label">Employee Id:</label>
				<div class="col-sm-4">
					<form:input type="text" path="empId" class="form-control" id="inputeid"
						value="${sessionScope.user.empId}" readonly="true"/>
				</div>
		</div>
	
		<div class="form-group row">
			<label for="inputfname" class="col-sm-2 col-form-label">First Name:</label>
				<div class="col-sm-4">
					<form:input type="text" path="firstName" class="form-control" id="inputfname"
						value="${sessionScope.user.firstName}" readonly="true"/>
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputlname" class="col-sm-2 col-form-label">Last Name:</label>
				<div class="col-sm-4">
					<form:input type="text" path="lastName" class="form-control" id="inputlname"
						value="${sessionScope.user.lastName}" readonly="true"/>
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputdob" class="col-sm-2 col-form-label">Date of Birth:</label>
				<div class="col-sm-4">
					<form:input type="text" path="dob" class="form-control" id="inputdob"
						value="${sessionScope.user.dob}" readonly="true"/>
				</div>
		</div>
		
		 <div class="form-group row">
			<label for="inputgender" class="col-sm-2 col-form-label">Gender:</label>
				<div class="col-sm-4">
					<form:input type="text" path="gender" class="form-control" id="inputdob"
						value="${sessionScope.user.gender}" readonly="true"/>
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputaddress" class="col-sm-2 col-form-label">Address:</label>
				<div class="col-sm-4">
					<form:textarea path="address" class="form-control" id="inputaddress" value="${sessionScope.user.address}"/>				
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputcontact" class="col-sm-2 col-form-label">Contact No:</label>
				<div class="col-sm-4">
					<form:input type="number" path="contactNo" class="form-control" id="inputcontact"
						value="${sessionScope.user.contactNo}"/>
				</div>
		</div>
		
		<div class="form-group row">
			<label for="inputemail" class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-4">
					<form:input type="email" path="email" class="form-control" id="inputemail"
						value="${sessionScope.user.email}"/>
				</div>
		</div>
		
		<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" name="btn" value="edit"
						class="btn btn-success">Edit Profile</button>
				</div>
				<div class="offset-sm-2 col-sm-10">
					<button type="reset" name="btn" value="Reset"
						class="btn btn-success">Clear</button>
				</div>
		</div>
		
		
	</form:form>
</div>
</body>
</html>