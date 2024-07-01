 <%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
	
	<form:form action="deleteNotice1" method="GET">
	<h3 align="center">Select Notices for delete:</h3><br>
    <c:forEach  var = "notice" items = "${requestScope.notices}" >
	<input type = "checkbox" value="${notice.noticeId}" name="notices">${notice.noticeText}
	<br><br>
    </c:forEach>
    <br>
    <input type="submit" class="btn btn-info" value = "Delete">
    </form:form>
</div>	
</body>
</html>