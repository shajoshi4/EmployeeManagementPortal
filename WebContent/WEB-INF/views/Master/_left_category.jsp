<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes.jsp"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<h3>Notices for ${sessionScope.user.dept.deptName} Department:</h3>
<marquee bgcolor=#99ccff direction=down width=250 height=350>

	<c:forEach  var = "viewNotice" items = "${requestScope.viewNotices}" >
	<ul>
	
				<li>${viewNotice.noticeText}</li>
				
				
	</ul>
	
	
	</c:forEach>
	

	
</marquee>

</body>
</html>
