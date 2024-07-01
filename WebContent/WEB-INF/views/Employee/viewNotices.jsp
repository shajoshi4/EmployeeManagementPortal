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
	<div class="container">
	<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headeremp.jsp"></jsp:include>
		</div><br><br><br><br><br>
	
	<h3 align="center">Notices for ${sessionScope.user.dept.deptName} Department:</h3>

		
	
	<c:forEach  var = "viewNotice" items = "${requestScope.viewNotices}" >
	<ul>
	
				<li>${viewNotice.noticeText}</li>
				
				
	</ul>
	
	
	</c:forEach>
	</div>
</body>
</html>