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
			<jsp:include page="/WEB-INF/views/Master/_headeremp.jsp"></jsp:include>
		</div><br><br>
		<form:form action="leave" method = "POST" modelAttribute="leave">

			<div class="form-group row">
				<label for="inputmgrId" class="col-sm-2 col-form-label">To:</label>
				<div class="col-sm-4">
					<form:input type="text" value="${sessionScope.user.managerId}" path="requestedTo.empId" class="form-control" id="inputmgrId"
					readonly="true"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label for="inputempId" class="col-sm-2 col-form-label">BY:</label>
				<div class="col-sm-4">
					<form:input type="text" value="${sessionScope.user.empId}"  path="requestedBy.empId" class="form-control" id="inputempId"
						placeholder="Enter employee id" readonly="true"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputsubject" class="col-sm-2 col-form-label">Subject</label>
				<div class="col-sm-4">
					<form:input type="text" required="true" autofocus="true" path="subject"  class="form-control"
						id="inputsubject" placeholder="Enter Subject"/>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputdescri" class="col-sm-2 col-form-label">Description</label>
				<div class="col-sm-4">
					<form:input type="Clob" path="description" required="true" class="form-control"
						id="inputdescri" value="cold"/>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputfromdate" class="col-sm-2 col-form-label">From Date</label>
				<div class="col-sm-4">
					<form:input type="date"  required="true" path="fromDate" class="form-control"
						id="inputfromdate" placeholder="Enter date"/>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputtodate" class="col-sm-2 col-form-label">To Date</label>
				<div class="col-sm-4">
					<form:input type="date"  required="true"  path="toDate" class="form-control"
						id="inputtodate" placeholder="Enter date"/>
				</div>
			</div>
			
			
			
			
			<div class="form-group row">
				<label for="inputstatus" class="col-sm-2 col-form-label"></label>
				<div class="col-sm-4">
					<form:input type="hidden"  path="status" value='P' class="form-control" id="inputstatus"
						/>
						
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