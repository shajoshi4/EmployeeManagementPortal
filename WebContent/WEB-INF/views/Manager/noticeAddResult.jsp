<%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notice Result page</title>
</head>
<body>
<div class="container">
     <div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headermgr.jsp"></jsp:include>
		</div><br><br><br><br><br>
	<h3>${requestScope.msg}</h3>
</div>
	
</body>
</html>