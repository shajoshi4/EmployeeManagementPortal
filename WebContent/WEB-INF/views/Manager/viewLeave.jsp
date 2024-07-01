 <%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leave List</title>
</head>
<body>

<div class=container>
		<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headermgr.jsp"></jsp:include>
		</div><br><br><br><br><br>
	
	
	<h3 align="center">Leaves Requested:</h3>
	<table class="table table-bordered" border="1">

		<tr class="info">
			<th>LeaveId</th>
			<th>Subject</th>
			<th>FromDate</th>
			<th>ToDate</th>
			<th>RequestedBy</th>
			<th>Approve</th>
			<th>Decline</th>

		</tr>
	
	<c:forEach  var = "viewLeave" items = "${requestScope.viewLeaves}" >
	<tr class="info">
				<td>${viewLeave.leaveId} </td>
				<td>${viewLeave.subject}</td>
				<td>${viewLeave.fromDate}</td>
				<td>${viewLeave.toDate}</td>
				<td>${viewLeave.requestedBy.firstName}&nbsp; ${viewLeave.requestedBy.lastName}</td>
				<td><a href="permission?id=${viewLeave.leaveId}&amp;status=A"> Approve</a></td>
				<td><a href="permission?id=${viewLeave.leaveId}&amp;status=D"> Decline</a></td>
	</tr>
	
	</c:forEach>
	</table>
</div>	
</body>
</html>