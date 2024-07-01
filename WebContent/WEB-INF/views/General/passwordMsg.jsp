 <%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
		<c:when test="${sessionScope.designation=='M'}">
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

	<h3>${requestScope.msg}</h3>
	
</body>
</html>