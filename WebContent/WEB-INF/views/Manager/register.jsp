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
		<form:form action="register" method = "POST" modelAttribute="emp">

			<div class="form-group row">
				<label for="inputFirstName" class="col-sm-2 col-form-label">First Name</label>
				<div class="col-sm-4">
					<form:input type="text" required="true" path="firstName" class="form-control" id="inputFirstName"
						placeholder="Enter FirstName" autofocus="true"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputLastName"  class="col-sm-2 col-form-label">Last Name</label>
				<div class="col-sm-4">
					<form:input type="text" required="true"  path="lastName"  class="form-control"
						id="inputLastName" placeholder="Enter LastName"/>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputDOB" class="col-sm-2 col-form-label">DOB</label>
				<div class="col-sm-4">
					<form:input type="date" required="true" path="dob" class="form-control"
						id="DOB" placeholder="Enter DOB"/>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputgender" class="col-sm-2 col-form-label">Gender</label>
				<div class="col-sm-1">
					<form:radiobutton path="gender" class="form-control"
						id="inputgender" value='M' />Male</div>
				<div class="col-sm-1">
					<form:radiobutton path="gender"  class="form-control"
						id="inputgender" value='F' />Female
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputaddress" class="col-sm-2 col-form-label">Enter Address</label>
				<div class="col-sm-4">
					<form:input type="text" path="address" required="true" class="form-control"
						id="inputaddress" placeholder="Enter adress"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label for="inputregDate" class="col-sm-2 col-form-label">Enter registration date</label>
				<div class="col-sm-4">
					<form:input type="date" path="regDate"  required="true" lass="form-control"
						id="inputregDate" placeholder="reg date"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label for="inputcontactNo" class="col-sm-2 col-form-label">Enter Contact No</label>
				<div class="col-sm-4">
					<form:input type="text" path="contactNo" required="true"  class="form-control"
						id="inputcontactNo" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputemail" class="col-sm-2 col-form-label">Enter Email</label>
				<div class="col-sm-4">
					<form:input type="email" path="email"  required="true" class="form-control"
						id="inputemail" placeholder="Enter email"/>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputpassword" class="col-sm-2 col-form-label">Enter Password</label>
				<div class="col-sm-4">
					<form:input type="text" path="password"  class="form-control"
						id="inputpassword" required="true" placeholder="Enter password"/>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputManagerId" class="col-sm-2 col-form-label">Manager Id</label>
				<div class="col-sm-4">
					<form:input type="text" value="${sessionScope.user.empId}" path="managerId"  class="form-control"
						id="inputManagerId" readonly="true" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputDepartmentId" class="col-sm-2 col-form-label">Department Id</label>
				<div class="col-sm-4">
					<form:input type="text"  path="dept.deptId" value="${sessionScope.user.dept.deptId}" class="form-control"
						id="inputDepartmentId" readonly="true"/>
				</div>
			</div>
			

			<div class="form-group row">
<table>
 <tr>
 <td>
				<div class="offset-sm-2 col-sm-10">
					<button type="Submit" name="btn" value="Cancel"
						class="btn btn-danger">Cancel registration</button>
				
				</div></td>
<td>
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" name="btn" value="Register"
						class="btn btn-info">Register </button>
				</div></td>
</tr>
</table>
			</div>

		</form:form>
		
	</div>

	<!-- jQuery 1.9 -->
	<%--Bootstrap JS --%>
	<script src="<spring:url value='/js/jquery.1.9.1.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
</body>
</html>