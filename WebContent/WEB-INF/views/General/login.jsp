 <%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<spring:url value='/bootstrap/css/bootstrap.css'/>"
	type="text/css" rel="stylesheet" />
<link href="<spring:url value='/bootstrap/css/style.css'/>"
	type="text/css" rel="stylesheet" />
	
	
	
</head>
<body background="../bootstrap/img/building1.jpg">
<div class="container"  style="color:white">
	<br><br><br><br>

	<form:form action="login" method="POST" modelAttribute="person">
		<div class="form-group row">
		
			<label for="email" class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-4" >
					<form:input type="email" path="email" class="form-control" id="email"
						placeholder="abc@gmail.com"/>
				</div>
		
		</div>
		
		<div class="form-group row" >
			<label for="inputlname" class="col-sm-2 col-form-label">Password:</label>
				<div class="col-sm-4">
					<form:password path="password" class="form-control" id="inputlname" placeholder="Enter Password"/>
				</div>
		</div>
		
		<div class="form-group row" >
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" name="btn" value="Login"
						class="btn btn-primary">Login</button>
				</div>
		</div>
	</form:form>
	</div>

</body>
</html>